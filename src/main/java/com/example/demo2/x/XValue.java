package com.example.demo2.x;

import java.util.ArrayList;
import java.util.List;


class XValue<T> {
	private final T value;
	private final List<XError> errors = new ArrayList<>();

	public XValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
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
		return "Parsed{" +
			   "value=" + value +
			   ", errors=" + errors +
			   '}';
	}
}
