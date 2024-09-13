package com.example.demo2;

import java.util.List;

public class XString extends AbstractXSchema<String> {
	public XString minLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() < length) {
				parsed.addError("min-length");
			}

			return parsed;
		});

		return this;
	}

	public XString maxLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() > length) {
				parsed.addError("max-length");
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

		return new XResult(List.of("expcted-string"));
	}
}
