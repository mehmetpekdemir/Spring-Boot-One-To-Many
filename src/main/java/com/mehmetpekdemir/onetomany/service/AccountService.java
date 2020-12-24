package com.mehmetpekdemir.onetomany.service;

import java.util.List;

import com.mehmetpekdemir.onetomany.dto.request.AccountCreateRequest;
import com.mehmetpekdemir.onetomany.dto.request.AccountUpdateRequest;
import com.mehmetpekdemir.onetomany.dto.response.AccountResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface AccountService {

	List<AccountResponse> getAccounts();

	AccountResponse getAccountByAccountNumber(String accountNumber);

	void createAccount(AccountCreateRequest accountCreateRequest);

	void updateAccount(AccountUpdateRequest accountUpdateRequest);

	void deleteAccount(String accountNumber);

	boolean existsUserByAccountNumber(String accountNumber);

}
