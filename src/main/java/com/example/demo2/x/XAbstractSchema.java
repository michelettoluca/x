package com.example.demo2.x;

import java.util.List;
import java.util.function.BiConsumer;

abstract class XAbstractSchema<T> implements XSchema {
	protected BiConsumer<T, XResult> chain = (value, errors) -> {
	};

	protected void register(BiConsumer<T, XResult> current) {
		chain = chain.andThen(current);
	}

	protected abstract void type(Object obj, XResult errors);

	private boolean isNullable = false;

	public XSchema nullable() {
		isNullable = true;

		return this;
	}

	@Override
	public XResult safeParse(Object obj) {
		XResult result = new XResult();

		if (obj != null) {
			type(obj, result);
		} else if (!isNullable){
			result.addError("null");
		}

		return result;
	}

	@Override
	public void parse(Object obj) throws XException {
		XResult result = safeParse(obj);

		if (result.hasErrors()) {
			throw new XException(result.getErrors());
		}
	}
}
