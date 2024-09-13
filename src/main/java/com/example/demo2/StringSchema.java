package com.example.demo2;

public class StringSchema extends Schema<String> {
	public StringSchema minLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() < length) {
				parsed.addError("min-length");
			}

			return parsed;
		});

		return this;
	}

	public StringSchema maxLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() > length) {
				parsed.addError("max-length");
			}

			return parsed;
		});

		return this;
	}

	public Parsed<String> safeParse(Object obj) {
		if (obj instanceof String str) {

			return chain.apply(str);
		}

		return new Parsed<>(null);
	}
}
