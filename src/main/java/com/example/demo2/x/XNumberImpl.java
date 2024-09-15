package com.example.demo2.x;

import java.util.List;

class XNumberImpl extends XAbstractSchema<Number> implements XNumber {
	@Override
	public XNumber min(Number min) {
		register((value, errors) -> {
			if (value.doubleValue() < min.doubleValue()) {
				errors.addError("min");
			}
		});

		return this;
	}

	@Override
	public XNumber max(Number max) {
		register((value, errors) -> {
			if (value.doubleValue() > max.doubleValue()) {
				errors.addError("max");
			}
		});

		return this;
	}

	@Override
	public XNumber equals(Number target) {
		register((value, errors) -> {
			if (value.doubleValue() != target.doubleValue()) {
				errors.addError("equals");
			}
		});

		return this;
	}

	@Override
	public void type(Object obj, XResult result) {
		if (obj instanceof Number value) {
			chain.accept(value, result);
		} else {
			result.addError("Expected String, but got " + obj.getClass().getSimpleName());
		}
	}
}
