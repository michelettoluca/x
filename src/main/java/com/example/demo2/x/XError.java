package com.example.demo2.x;

public class XError {
	private final String message;

	public XError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "XError{" +
			   "message='" + message + '\'' +
			   '}';
	}
}
