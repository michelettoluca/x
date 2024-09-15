package com.example.demo2.x;

import java.util.List;

class XNumberImpl extends XAbstractSchema<Number> implements XNumber {
	@Override
	public XNumber min(Number min) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().doubleValue() < min.doubleValue()) {
				parsed.addError(new XError("min"));
			}

			return parsed;
		});

		return this;
	}

	@Override
	public XNumber max(Number max) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().doubleValue() > max.doubleValue()) {
				parsed.addError(new XError("max"));
			}

			return parsed;
		});

		return this;
	}

	@Override
	public XNumber equals(Number value) {
		chain = chain.andThen((xValue) -> {
			if (xValue.getValue().doubleValue() != value.doubleValue()) {
				xValue.addError(new XError("not-equal"));
			}

			return xValue;
		});

		return this;
	}

	@Override
	public XResult _parse(Object obj) {
		if (obj instanceof Number number) {
			return new XResult(chain.apply(number).getErrors());
		}

		return new XResult(List.of(new XError("expected-double")));
	}
}
