package com.kaylerrenslow.plugin.lang.header.highlighting;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Kayler on 11/01/2015.
 */
public class HeaderSyntaxHighlighterFactory extends SyntaxHighlighterFactory{

	@NotNull
	@Override
	public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
		return new HeaderSyntaxHighlighter();
	}

}
