package com.mehmetpekdemir.onetomany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetomany.common.constant.ExceptionMessages;
import com.mehmetpekdemir.onetomany.dto.request.AccountCreateRequest;
import com.mehmetpekdemir.onetomany.dto.request.AccountUpdateRequest;
import com.mehmetpekdemir.onetomany.dto.response.AccountResponse;
import com.mehmetpekdemir.onetomany.entity.AccountEntity;
import com.mehmetpekdemir.onetomany.entity.EmployeeEntity;
import com.mehmetpekdemir.onetomany.exception.CustomException;
import com.mehmetpekdemir.onetomany.repository.AccountRepository;
import com.mehmetpekdemir.onetomany.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<AccountResponse> getAccounts() {
		return accountRepository.findAll().stream() //
				.map(account -> mapToAccountResponse(account)) //
				.collect(Collectors.toList()); //
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public AccountResponse getAccountByAccountNumber(String accountNumber) {
		final AccountEntity account = accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new CustomException(ExceptionMessages.ACCOUNT_NOT_FOUND, HttpStatus.BAD_REQUEST));

		return mapToAccountResponse(account);
	}

	@Override
	@Transactional
	public void createAccount(AccountCreateRequest accountCreateRequest) {
		final EmployeeEntity employee = employeeRepository.findByUserName(accountCreateRequest.getUserName())
				.orElseThrow(() -> new CustomException(ExceptionMessages.EMPLOYEE_NOT_FOUND, HttpStatus.BAD_REQUEST));

		accountRepository.save(new AccountEntity(accountCreateRequest.getAccountNumber(), employee));
	}

	@Override
	@Transactional
	public void updateAccount(AccountUpdateRequest accountUpdateRequest) {
		final EmployeeEntity employee = employeeRepository.findByUserName(accountUpdateRequest.getUserName())
				.orElseThrow(() -> new CustomException(ExceptionMessages.EMPLOYEE_NOT_FOUND, HttpStatus.BAD_REQUEST));

		accountRepository.save(new AccountEntity(accountUpdateRequest.getAccountNumber(), employee));
	}

	@Override
	@Transactional
	public void deleteAccount(String accountNumber) {
		final AccountEntity account = accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new CustomException(ExceptionMessages.ACCOUNT_NOT_FOUND, HttpStatus.BAD_REQUEST));

		accountRepository.deleteById(account.getId());
	}

	@Override
	@Transactional
	public boolean existsUserByAccountNumber(String accountNumber) {
		return accountRepository.existsAccountByAccountNumber(accountNumber);
	}

	private AccountResponse mapToAccountResponse(AccountEntity account) {
		return AccountResponse.builder() //
				.accountNumber(account.getAccountNumber()) //
				.fullName(account.getEmployee().getFirstName() + " " + account.getEmployee().getLastName()) //
				.build(); //
	}

}
