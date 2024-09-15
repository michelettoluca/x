package com.example.demo2.x;

import java.util.List;

public record XResult(List<XError> errors) {
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
}
