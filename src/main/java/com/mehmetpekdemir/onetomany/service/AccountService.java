package com.mehmetpekdemir.onetomany.service;

import java.util.List;

import com.mehmetpekdemir.onetomany.dto.response.AccountResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface AccountService {

	List<AccountResponse> getAccounts();

}
