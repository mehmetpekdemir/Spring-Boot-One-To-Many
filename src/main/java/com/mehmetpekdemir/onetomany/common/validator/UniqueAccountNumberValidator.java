package com.mehmetpekdemir.onetomany.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mehmetpekdemir.onetomany.service.AccountService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
public final class UniqueAccountNumberValidator implements ConstraintValidator<UniqueAccountNumber, String> {

	private final AccountService accountService;

	@Override
	public boolean isValid(String accountNumber, ConstraintValidatorContext context) {
		return !accountService.existsUserByAccountNumber(accountNumber);
	}

}