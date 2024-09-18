package com.example.demo2.x;

import java.util.function.Function;

public class XString extends AbstractXSchema<String> {
	XString() {
	}

	public XString minLength(int min) {
		addValidator((value) -> {
			if (value.length() < min) {
				return new XError("min");
			}

			return null;
		});

		return this;
	}

	public XString maxLength(int max) {
		addValidator((value) -> {
			if (value.length() > max) {
				return new XError("max");
			}

			return null;
		});

		return this;
	}


	public XString addValidator(Function<String, XError> validator) {
		return (XString) super.addValidator(validator);
	}
}
