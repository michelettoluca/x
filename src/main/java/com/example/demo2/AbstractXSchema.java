package com.example.demo2;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractXSchema<T> implements XSchema {
	protected Function<T, XInternalValue<T>> chain = XInternalValue::new;

	private boolean isNullable = false;

	public XResult parse(Object obj) {
		if(obj == null) {
			return new XResult(isNullable ? List.of() : List.of("null"));
		}

		return this._parse(obj);
	}

	public abstract XResult _parse(Object obj);

	public XSchema nullable() {
		isNullable = true;

		return this;
	}
}
