package com.emp.constraint;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Range implements ConstraintValidator<CheckRange, String> {
	private  String[] ALL_STATUS = null;

	public void initialize(CheckRange checkRange) {
		ALL_STATUS=checkRange.range();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Arrays.asList(ALL_STATUS).contains(value))
			return true;
		return false;
	}
}
