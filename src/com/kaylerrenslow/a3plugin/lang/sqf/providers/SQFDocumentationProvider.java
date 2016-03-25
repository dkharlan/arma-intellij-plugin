package com.kaylerrenslow.a3plugin.lang.sqf.providers;

import com.intellij.lang.ASTNode;
import com.intellij.lang.documentation.DocumentationProviderEx;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.*;
import com.kaylerrenslow.a3plugin.Plugin;
import com.kaylerrenslow.a3plugin.lang.shared.PsiUtil;
import com.kaylerrenslow.a3plugin.lang.sqf.SQFStatic;
import com.kaylerrenslow.a3plugin.lang.sqf.psi.SQFAssignment;
import com.kaylerrenslow.a3plugin.lang.sqf.psi.SQFStatement;
import com.kaylerrenslow.a3plugin.lang.sqf.psi.SQFTypes;
import com.kaylerrenslow.a3plugin.lang.sqf.psi.SQFVariable;
import com.kaylerrenslow.a3plugin.lang.sqf.psi.references.SQFVariableReference;
import com.kaylerrenslow.a3plugin.util.FileReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kayler
 * Provides documentation for SQF PsiElements
 * Created on 01/03/2016.
 */
public class SQFDocumentationProvider extends DocumentationProviderEx{
	private static final String COMMAND_URL_PREFIX = Plugin.resources.getString("plugin.doc.sqf.command_URL_prefix");
	private static final String COMMAND_DOC_EXTERNAL_LINK_NOTIFICATION = Plugin.resources.getString("plugin.doc.sqf.command_doc_external_link_notification_string_format");

	@Nullable
	@Override
	public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
		return generateDoc(element, originalElement);
	}

	@Nullable
	@Override
	public List<String> getUrlFor(PsiElement element, PsiElement originalElement) {
		List<String> lst = new ArrayList<>(); ///test
		if (PsiUtil.isOfElementType(element, SQFTypes.COMMAND)){
			lst.add(getCommandUrl(element.getText()));
			return lst;
		}
		return null;
	}

	@Nullable
	@Override
	public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
		if (PsiUtil.isOfElementType(element, SQFTypes.COMMAND)){
			return generateCommandDoc(element.getText());
		}
		if (PsiUtil.isOfElementType(element, SQFTypes.COMMENT) || PsiUtil.isOfElementType(element, SQFTypes.BLOCK_COMMENT)){
			return element.getNode().getText().replaceAll("\n", "<br>");
		}
		if (element instanceof PsiFile){
			ASTNode potentialDoc = element.getNode().getFirstChildNode();
			if (!PsiUtil.isOfElementType(potentialDoc, SQFTypes.COMMENT) && !PsiUtil.isOfElementType(potentialDoc, SQFTypes.BLOCK_COMMENT)){
				potentialDoc = potentialDoc.getTreeNext();
			}
			if(PsiUtil.isOfElementType(potentialDoc, SQFTypes.COMMENT) || PsiUtil.isOfElementType(potentialDoc, SQFTypes.BLOCK_COMMENT)){
				return potentialDoc.getText().replaceAll("\n", "<br>");
			}
			return null;
		}
		return null;
	}

	@Nullable
	@Override
	public PsiElement getDocumentationElementForLookupItem(PsiManager psiManager, Object object, PsiElement element) {
		if (PsiUtil.isOfElementType(element, SQFTypes.COMMAND)){
			return element;
		}
		if (element instanceof PsiFile){
			return element;
		}

		return null;
	}

	@Nullable
	@Override
	public PsiElement getDocumentationElementForLink(PsiManager psiManager, String link, PsiElement context) {
		//		StringBuilder sb = new StringBuilder();
		//		DocumentationManagerUtil.createHyperlink(sb, "refText", "label", true); this is for creating links between psi elements
		return null;
	}

	@Override
	@Nullable
	public PsiElement getCustomDocumentationElement(@NotNull final Editor editor, @NotNull final PsiFile file, @Nullable PsiElement contextElement) {
		if (PsiUtil.isOfElementType(contextElement, SQFTypes.COMMAND)){
			return contextElement;
		}


		if(PsiUtil.isOfElementType(contextElement, SQFTypes.LOCAL_VAR)){ //this code works, but only when the selected statement has the comment
			SQFVariable var = (SQFVariable)(contextElement.getParent());
			PsiReference[] references = var.getReferences();
			for(PsiReference reference : references){
				if(reference.getElement().getParent() instanceof SQFAssignment){
					SQFStatement statement = (SQFStatement) reference.getElement().getParent().getParent();
					PsiElement comment = getInlineComment(editor, statement.getNode());
					if (comment != null){
						return comment;
					}
				}
			}
		}

		return null;
	}

	@Nullable
	private PsiElement getInlineComment(@NotNull Editor editor, ASTNode statementNode) {
		ASTNode commentNode = PsiUtil.getNextSiblingNotWhitespace(statementNode);
		if (PsiUtil.isOfElementType(commentNode, SQFTypes.COMMENT) || PsiUtil.isOfElementType(commentNode, SQFTypes.BLOCK_COMMENT)){
			if (editor.getDocument().getLineNumber(statementNode.getStartOffset()) != editor.getDocument().getLineNumber(commentNode.getStartOffset())){ //comment not on same line
				return null;
			}
			return commentNode.getPsi();
		}
		return null;
	}


	private String generateCommandDoc(String commandName) {
		String doc = String.format(COMMAND_DOC_EXTERNAL_LINK_NOTIFICATION, getCommandUrl(commandName));
		try{
			doc += FileReader.getText(SQFStatic.COMMANDS_DOC_FILE_DIR + commandName);
		}catch (Exception e){
			e.printStackTrace();
		}
		return doc;
	}

	private String getCommandUrl(String commandName) {
		return COMMAND_URL_PREFIX + commandName;
	}

}