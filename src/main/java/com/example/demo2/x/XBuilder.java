package com.example.demo2.x;

public class XBuilder {
	public static XString string() {
		return new XStringImpl();
	}

	public static XNumber number() {
		return new XNumberImpl();
	}
}
