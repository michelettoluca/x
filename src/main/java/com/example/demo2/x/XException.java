package com.example.demo2.x;

import java.util.List;

public class XException extends Exception {
	private final List<XError> errors;

	XException(List<XError> errors) {
		this.errors = errors;
	}

	public List<XError> getErrors() {
		return errors;
	}

	@Override
	public String getMessage() {
		return errors.toString();
	}

}
