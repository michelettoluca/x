package com.example.demo2;

import java.util.List;

public record ParseResult(List<String> errors) {
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
}
