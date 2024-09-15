package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

class XStringImpl extends XAbstractSchema<String> implements XString {
	@Override
	public XString minLength(int length) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			if (value.length() < length) {
				x.addError(buildError("min-length"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XString maxLength(int length) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			if (value.length() > length) {
				x.addError(buildError("max-length"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XString equals(String string) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			if (!value.equals(string)) {
				x.addError(buildError("not-equal"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XString matches(String regex) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			if (!value.matches(regex)) {
				x.addError(buildError(""));
			}

			return x;
		});

		return this;
	}

	@Override
	public XString in(List<String> options) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			if (!options.contains(value)) {
				x.addError(buildError("in"));
			}

			return x;
		});

		return this;
	}

	@Override
	public <T> XString in(List<T> options, Function<T, String> getter) {
		chain = chain.andThen((x) -> {
			String value = x.getValue();

			boolean isContained = options
				.stream()
				.anyMatch(option -> getter.apply(option).equals(value));

			if (isContained) {
				x.addError(buildError("in"));
			}

			return x;
		});

		return this;
	}

	@Override
	protected XResult type(Object obj) {
		if (obj instanceof String value) {
			return new XResult(chain.apply(value).getErrors());
		}

		return new XResult(List.of(buildError("Expected String, but got " + obj.getClass().getSimpleName())));
	}
}
