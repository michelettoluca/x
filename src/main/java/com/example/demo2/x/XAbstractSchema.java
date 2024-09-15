package com.example.demo2.x;

import java.util.function.BiConsumer;

abstract class XAbstractSchema<T> implements XSchema {
	protected BiConsumer<T, XResult> parser = (value, errors) -> {
	};

	private boolean isNullable = false;

	public XSchema nullable() {
		isNullable = true;

		return this;
	}

	protected abstract void type(Object obj, XResult errors);

	public void register(BiConsumer<T, XResult> parser) {
		this.parser = this.parser.andThen(parser);
	}

	@Override
	public XResult safeParse(Object obj) {
		XResult result = new XResult();

		if (obj != null) {
			type(obj, result);
		} else if (!isNullable) {
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
