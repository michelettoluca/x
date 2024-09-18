package com.example.demo2.x;

import java.util.ArrayList;
import java.util.List;

public class XResult {
	private final List<XError> errors = new ArrayList<>();

	public void addError(String message) {
		errors.add(new XError(message));
	}

	public void addError(XError error) {
		if (error != null) {
			errors.add(error);
		}
	}


	public List<XError> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return "XResult{" +
			   "errors=" + errors +
			   '}';
	}
}
