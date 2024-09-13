package com.example.demo2;

import java.util.List;
import java.util.function.Function;

public class VString implements Parsable {
	private Function<String, Parsed<String>> chain = Parsed::new;

//	public VString() {
//		chain = chain.andThen((parsed) -> {
//
//			return parsed;
//		});
//
//		return this;
//	}

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
			if (parsed.getValue().length() < length) {
				parsed.addError("min-length");
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

	@Override
	public ParseResult parse(Object obj) {
		if (obj instanceof String str) {
			return new ParseResult(chain.apply(str).getErrors());
		}

		return new ParseResult(List.of("Expected string"));
	}
}
