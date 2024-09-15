package com.example.demo2.x;


class XNumberImpl extends XAbstractSchema<Number> implements XNumber {
	@Override
	public void type(Object obj, XResult result) {
		if (obj instanceof Number value) {
			parser.accept(value, result);
		} else {
			result.addError("Expected Number, but got " + obj.getClass().getSimpleName());
		}
	}

	@Override
	public XNumber min(Number min) {
		register((value, result) -> {
			if (value.doubleValue() < min.doubleValue()) {
				result.addError("min");
			}
		});

		return this;
	}

	@Override
	public XNumber max(Number max) {
		register((value, result) -> {
			if (value.doubleValue() > max.doubleValue()) {
				result.addError("max");
			}
		});

		return this;
	}

	@Override
	public XNumber equals(Number target) {
		register((value, result) -> {
			if (value.doubleValue() != target.doubleValue()) {
				result.addError("equals");
			}
		});

		return this;
	}
}
