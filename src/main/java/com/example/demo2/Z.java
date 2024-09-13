package com.example.demo2;

public abstract class Z<T> extends Schema<T> {
	public static class ParseSchemaException extends Exception {
	}

	public static StringSchema string() {
		return new StringSchema();
	}

//	public static Z nullable() {
//
//	}
}
