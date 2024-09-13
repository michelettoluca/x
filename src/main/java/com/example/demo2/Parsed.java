package com.example.demo2;

import java.util.ArrayList;
import java.util.List;


public class Parsed<T> {
	private final T value;
	private final List<String> errors = new ArrayList<>();

	public Parsed(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void addError(String error) {
		errors.add(error);
	}

	public List<String> getErrors() {
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
