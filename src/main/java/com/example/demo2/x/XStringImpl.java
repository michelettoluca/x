package com.example.demo2.x;

import java.util.List;

class XStringImpl extends XAbstractSchema<String> implements XString {
	@Override
	public XString minLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() < length) {
				parsed.addError(new XError("min-length"));
			}

			return parsed;
		});

		return this;
	}

	@Override
	public XString maxLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() > length) {
				parsed.addError(new XError("max-length"));
			}

			return parsed;
		});

		return this;
	}

	@Override
	public XString equals(String string) {
		chain = chain.andThen((parsed) -> {
			if (!parsed.getValue().equals(string)) {
				parsed.addError(new XError("not-equal"));
			}

			return parsed;
		});

		return this;
	}

	@Override
	public XResult _parse(Object obj) {
		if (obj instanceof String string) {
			return new XResult(chain.apply(string).getErrors());
		}

		return new XResult(List.of(new XError("expected-string")));
	}
}
