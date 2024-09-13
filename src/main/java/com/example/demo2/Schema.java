package com.example.demo2;

import java.util.List;
import java.util.function.Function;

public abstract class Schema<T> {
	protected Function<T, Parsed<T>> chain = Parsed::new;

	private boolean isNullable = false;

	public ParseResult parse(T obj) {
		if (obj == null) {
			return new ParseResult(isNullable ? List.of() : List.of("null"));
		}

		return new ParseResult(chain.apply(obj).getErrors());
	}

	public Schema<T> nullable() {
		isNullable = true;

		return this;
	}
}
