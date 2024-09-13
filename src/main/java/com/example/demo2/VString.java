package com.example.demo2;

import java.util.function.Function;

public class VString {
	private Function<String, Parsed<String>> chain = Parsed::new;

	public VString minLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() < length) {
				parsed.addError("min-length");
			}

			return parsed;
		});

		return this;
	}

	public VString maxLength(int length) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().length() > length) {
				parsed.addError("max-length");
			}

			return parsed;
		});

		return this;
	}

	public Parsed<String> parse(Object obj) {
		if (obj instanceof String str) {
			return chain.apply(str);
		}

		return new Parsed<>(null);
	}
}
