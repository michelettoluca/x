package com.example.demo2.x;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractXSchema<T> implements XSchema {
	private boolean isNullable = false;
	private final List<Function<T, XError>> validators = new ArrayList<>();

	@Override
	public XSchema nullable() {
		isNullable = true;

		return this;
	}

	public AbstractXSchema<T> addValidator(Function<T, XError> validator) {
		validators.add(validator);

		return this;
	}



	@SuppressWarnings("unchecked")
	@Override
	public XResult parse(Object obj) {
		XResult result = new XResult();

		if (obj == null) {
			if (!isNullable) {
				result.addError("null");
			}

			return result;
		}

		try {
			T value = (T) obj;

			validators.forEach(validator -> result.addError(validator.apply(value)));
		} catch (ClassCastException e) {
			result.addError("cast");
		}

		return result;
	}
}
