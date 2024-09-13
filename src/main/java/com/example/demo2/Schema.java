package com.example.demo2;

import java.util.List;

public class Schema {
	public static class ParseSchemaException extends Exception {}

	public record ValidationResult(List<String> errors) {
		public boolean hasErrors() {
			return errors.isEmpty();
		}
	}

	public static Parsable string() {
		return new VString();
	}

//	public void parse(Object obj) throws ParseSchemaException {
//
//	}

//	public ValidationResult safeParse(Object obj) {
//		try {
//			this.
//		}
//		return
//	}
//
	public static Schema nullable() {

	}
 }
