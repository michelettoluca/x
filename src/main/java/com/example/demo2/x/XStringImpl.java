package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

class XStringImpl extends XAbstractSchema<String> implements XString {
	@Override
	protected void type(Object obj, XResult result) {
		if (obj instanceof String value) {
			parser.accept(value, result);
		} else {
			result.addError("Expected String, but got " + obj.getClass().getSimpleName());
		}
	}

	@Override
	public XString minLength(int length) {
		register((value, result) -> {
			if (length > value.length()) {
				result.addError("min-length");
			}
		});

		return this;
	}

	@Override
	public XString maxLength(int length) {
		register((value, result) -> {
			if (value.length() > length) {
				result.addError("max-length");
			}
		});

		return this;
	}

	@Override
	public XString equals(String string) {
		register((value, result) -> {
			if (!value.equals(string)) {
				result.addError("not-equal");
			}
		});

		return this;
	}

	@Override
	public XString matches(String regex) {
		register((value, result) -> {
			if (!value.matches(regex)) {
				result.addError("regex");
			}
		});

		return this;
	}

	@Override
	public XString in(List<String> options) {
		register((value, result) -> {
			if (!options.contains(value)) {
				result.addError("in");
			}
		});

		return this;
	}

	@Override
	public <T> XString in(List<T> options, Function<T, String> getter) {
		register((value, result) -> {
			boolean isContained = options
				.stream()
				.anyMatch(option -> getter.apply(option).equals(value));

			if (isContained) {
				result.addError("in");
			}
		});

		return this;
	}
}
