package com.kaylerrenslow.armaplugin.lang.sqf.syntax;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Kayler
 * @since 02/18/2017
 */
public class ArrayParam extends Param implements ArrayValueHolder {

	private boolean unboundedParams;
	private List<Param> params;

	public ArrayParam(boolean unboundedParams, @NotNull List<Param> params) {
		this(unboundedParams, params, false);
	}

	public ArrayParam(boolean unboundedParams, @NotNull List<Param> params, boolean optional) {
		this(unboundedParams, params, optional, "");
	}

	public ArrayParam(boolean unboundedParams, @NotNull List<Param> params, boolean optional, @NotNull String description) {
		super("ARRAY", ValueType.ARRAY, description, optional);
		this.unboundedParams = unboundedParams;
		this.params = params;
	}

	public boolean hasUnboundedParams() {
		return unboundedParams;
	}

	@Override
	@NotNull
	public List<? extends ValueHolder> getValueHolders() {
		return getParams();
	}

	@NotNull
	public List<Param> getParams() {
		return params;
	}
}