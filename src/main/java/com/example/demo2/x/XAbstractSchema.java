package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

abstract class XAbstractSchema<T> implements XSchema {
	protected Function<T, XValue<T>> chain = XValue::new;

	protected abstract XResult type(Object obj);

	private boolean isNullable = false;

	public XSchema nullable() {
		isNullable = true;

		return this;
	}

	@Override
	public XResult safeParse(Object obj) {
		if (obj == null) {
			return new XResult(isNullable ? List.of() : List.of(buildError("null")));
		}

		return this.type(obj);
	}

	@Override
	public void parse(Object obj) throws XException {
		XResult result = safeParse(obj);

		if (result.hasErrors()) {
			throw new XException(result.errors());
		}
	}

	protected XError buildError(String message) {
		StackTraceElement invoker = Thread.currentThread().getStackTrace()[2];
		String origin = invoker.getMethodName();

		if (origin.contains("lambda")) {
			origin = origin.split("\\$")[1];
		}

		return new XError(origin, message);
	}
}
