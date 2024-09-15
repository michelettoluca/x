package com.example.demo2.x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XResult {
	private final List<XError> errors = new ArrayList<>();

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public void addError(String message) {
		StackTraceElement invoker = Thread.currentThread().getStackTrace()[2];
		String origin = invoker.getMethodName();

		if (origin.contains("lambda")) {
			origin = origin.split("\\$")[1];
		}

		errors.add(new XError(origin, message));
	}

	public List<XError> getErrors() {
		return Collections.unmodifiableList(errors);
	}

	@Override
	public String toString() {
		return "XResult{" +
			   "errors=" + errors +
			   '}';
	}
}
