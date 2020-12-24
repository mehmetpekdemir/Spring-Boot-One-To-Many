package com.mehmetpekdemir.onetomany.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mehmetpekdemir.onetomany.common.GenericResponse;
import com.mehmetpekdemir.onetomany.common.annotation.ApiController;
import com.mehmetpekdemir.onetomany.common.constant.GenericMessages;
import com.mehmetpekdemir.onetomany.common.constant.SwaggerMessages;
import com.mehmetpekdemir.onetomany.dto.request.AccountCreateRequest;
import com.mehmetpekdemir.onetomany.dto.request.AccountUpdateRequest;
import com.mehmetpekdemir.onetomany.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ApiController
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@ApiOperation(value = "Get Accounts")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_COMPLETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@GetMapping("v1/accounts")
	public ResponseEntity<?> getAccounts() {

		final var response = accountService.getAccounts();
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Get Account By AccountNumber")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_COMPLETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@GetMapping("v1/account")
	public ResponseEntity<?> getAccountByAccountNumber( //
			@ApiParam(value = "Account Number", required = true) //
			@RequestParam(value = "accountNumber") String accountNumber) {

		final var response = accountService.getAccountByAccountNumber(accountNumber);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Create Account")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_CREATED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@PostMapping("v1/account")
	public ResponseEntity<?> createAccount( //
			@ApiParam(value = "Account Create Request", required = true) //
			@Valid @RequestBody AccountCreateRequest accountCreateRequest) {

		accountService.createAccount(accountCreateRequest);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
	}

	@ApiOperation(value = "Update Account")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_UPDATED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@PutMapping("v1/account")
	public ResponseEntity<?> updateAccount( //
			@ApiParam(value = "Account Update Request", required = true) //
			@Valid @RequestBody AccountUpdateRequest accountUpdateRequest) {

		accountService.updateAccount(accountUpdateRequest);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_UPDATED));
	}

	@ApiOperation(value = "Delete Account")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_DELETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@DeleteMapping("v1/account")
	public ResponseEntity<?> deleteAccount( //
			@ApiParam(value = "Account Number", required = true) //
			@RequestParam(value = "accountNumber") String accountNumber) {

		accountService.deleteAccount(accountNumber);
		return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_DELETED));
	}

}
