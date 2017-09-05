package com.kaylerrenslow.armaplugin.lang.sqf.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author Kayler
 * @since 05/23/2017
 */
public abstract class SQFAddExpression extends ASTWrapperPsiElement implements SQFBinaryExpression {
	public SQFAddExpression(@NotNull ASTNode node) {
		super(node);
	}
}
