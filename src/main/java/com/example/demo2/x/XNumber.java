package com.example.demo2.x;

public interface XNumber extends XSchema, Cloneable {
	XNumber min(Number min);

	XNumber max(Number max);

	XNumber equals(Number value);

	XNumber clone();
}
