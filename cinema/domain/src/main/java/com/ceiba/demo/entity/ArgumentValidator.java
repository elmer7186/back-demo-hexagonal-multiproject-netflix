package com.ceiba.demo.entity;

import com.ceiba.demo.exception.CinemaException;

public class ArgumentValidator {
	
	private ArgumentValidator() {}

	public static void validateRequired(Object argument, String message) {
		if (argument == null)
			throw new CinemaException(message);
	}
}
