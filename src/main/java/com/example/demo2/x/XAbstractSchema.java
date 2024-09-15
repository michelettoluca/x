package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

public abstract class XAbstractSchema<T> implements XSchema {
	protected Function<T, XValue<T>> chain = XValue::new;

	private boolean isNullable = false;

	public XResult parse(Object obj) {
		if(obj == null) {
			return new XResult(isNullable ? List.of() : List.of(new XError("null")));
		}

		return this._parse(obj);
	}

	public abstract XResult _parse(Object obj);

	public XSchema nullable() {
		isNullable = true;

		return this;
	}
}
