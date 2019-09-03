package com.emp.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = { Range.class })
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckRange {
	String message() default "不正确的状态 , 应该是 'created', 'paid', shipped', closed'其中之一";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String[] range() default {};

}
