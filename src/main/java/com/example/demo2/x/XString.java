package com.example.demo2.x;

public interface XString extends XSchema {
	XString minLength(int length);
	XString maxLength(int length);
	XString equals(String string);
}
