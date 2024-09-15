package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

abstract class XAbstractSchema<T> implements XSchema {
	protected Function<T, XValue<T>> chain = XValue::new;

	public abstract XResult _parse(Object obj);

	private boolean isNullable = false;

	public XSchema nullable() {
		isNullable = true;

		return this;
	}

	@Override
	public XResult safeParse(Object obj) {
		if (obj == null) {
			return new XResult(isNullable ? List.of() : List.of(new XError("null")));
		}

		return this._parse(obj);
	}

	@Override
	public void parse(Object obj) throws XException {
		XResult result = safeParse(obj);

		if (result.hasErrors()) {
			throw new XException(result.errors());
		}
	}
}
