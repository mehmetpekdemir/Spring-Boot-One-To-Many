package com.mehmetpekdemir.onetomany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetomany.dto.response.AccountResponse;
import com.mehmetpekdemir.onetomany.entity.AccountEntity;
import com.mehmetpekdemir.onetomany.repository.AccountRepository;

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

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<AccountResponse> getAccounts() {
		return accountRepository.findAll().stream() //
				.map(account -> mapToAccountResponse(account)) //
				.collect(Collectors.toList()); //
	}

	private AccountResponse mapToAccountResponse(AccountEntity account) {
		return AccountResponse.builder() //
				.accountNumber(account.getAccountNumber()) //
				.fullName(account.getEmployee().getFirstName() + " " + account.getEmployee().getLastName()) //
				.build(); //
	}

}
