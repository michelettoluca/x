package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

class XStringImpl extends XAbstractSchema<String> implements XString {
	@Override
	public XString minLength(int length) {
		register((value, errors) -> {
			if (length > value.length()) {
				errors.addError("min-length");
			}
		});

		return this;
	}

	@Override
	public XString maxLength(int length) {
		register((value, errors) -> {
			if (value.length() > length) {
				errors.addError("max-length");
			}
		});

		return this;
	}

	@Override
	public XString equals(String string) {
		register((value, errors) -> {
			if (!value.equals(string)) {
				errors.addError("not-equal");
			}
		});

		return this;
	}

	@Override
	public XString matches(String regex) {
		register((value, errors) -> {
			if (!value.matches(regex)) {
				errors.addError("regex");
			}
		});

		return this;
	}

	@Override
	public XString in(List<String> options) {
		register((value, errors) -> {
			if (!options.contains(value)) {
				errors.addError("in");
			}
		});

		return this;
	}

	@Override
	public <T> XString in(List<T> options, Function<T, String> getter) {
		register((value, errors) -> {
			boolean isContained = options
				.stream()
				.anyMatch(option -> getter.apply(option).equals(value));

			if (isContained) {
				errors.addError("in");
			}
		});

		return this;
	}

	@Override
	protected void type(Object obj, XResult result) {
		if (obj instanceof String value) {
			chain.accept(value, result);
		} else {
			result.addError("Expected String, but got " + obj.getClass().getSimpleName());
		}
	}
}
