package com.example.demo2.x;

import java.util.List;

class XNumber extends XAbstractSchema<Number> {
	public XNumber min(Double min) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().doubleValue() < min) {
				parsed.addError(new XError("min"));
			}

			return parsed;
		});

		return this;
	}

	public XNumber max(int max) {
		chain = chain.andThen((parsed) -> {
			if (parsed.getValue().doubleValue() > max) {
				parsed.addError(new XError("max"));
			}

			return parsed;
		});

		return this;
	}

	public XNumber equals(Double value) {
		chain = chain.andThen((xValue) -> {
			if (xValue.getValue().doubleValue() != value) {
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
