package com.example.demo2.x;

import java.util.List;
import java.util.function.Function;

public interface XString extends XSchema {
	XString minLength(int length);

	XString maxLength(int length);

	XString equals(String string);

	XString matches(String regex);

	XString in(List<String> options);

	<T> XString in(List<T> options, Function<T, String> getter);
}
