package com.example.demo2.x;

import java.util.List;

class XNumberImpl extends XAbstractSchema<Number> implements XNumber {
	@Override
	public XNumber min(Number min) {
		chain = chain.andThen((x) -> {
			Number value = x.getValue();

			if (value.doubleValue() < min.doubleValue()) {
				x.addError(buildError("min"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XNumber max(Number max) {
		chain = chain.andThen((x) -> {
			Number value = x.getValue();

			if (value.doubleValue() > max.doubleValue()) {
				x.addError(buildError("max"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XNumber equals(Number target) {
		chain = chain.andThen((x) -> {
			Number value = x.getValue();

			if (value.doubleValue() != target.doubleValue()) {
				x.addError(buildError("not-equal"));
			}

			return x;
		});

		return this;
	}

	@Override
	public XResult type(Object obj) {
		if (obj instanceof Number value) {
			return new XResult(chain.apply(value).getErrors());
		}

		return new XResult(List.of(buildError("Expected Number got " + obj.getClass().getSimpleName())));
	}
}
