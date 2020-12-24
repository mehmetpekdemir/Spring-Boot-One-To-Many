package com.mehmetpekdemir.onetomany.common.constant;

/**
 * 
 * Exception Messages
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class ExceptionMessages {

	private static final String UTILITY_CLASS = "Utility Class";

	private ExceptionMessages() {
		throw new IllegalArgumentException(UTILITY_CLASS);
	}

	public static final String ACCOUNT_NOT_FOUND = "Account Not Found !";
	
	public static final String EMPLOYEE_NOT_FOUND = "Employee Not Found !";

}