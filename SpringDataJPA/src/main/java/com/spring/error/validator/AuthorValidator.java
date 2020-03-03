package com.spring.error.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidator implements ConstraintValidator<Author, String>{
	
	List<String> authors = Arrays.asList("Santideva","Marie Kondo","Martin Fowler");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return authors.contains(value);
	}
	
	

}
