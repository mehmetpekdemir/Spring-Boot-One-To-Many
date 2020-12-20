package com.mehmetpekdemir.onetomany.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.mehmetpekdemir.onetomany.common.annotation.ApiController;
import com.mehmetpekdemir.onetomany.common.constant.SwaggerMessages;
import com.mehmetpekdemir.onetomany.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
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
public class EmployeeController {

	private final EmployeeService employeeService;

	@ApiOperation(value = "Get Employees")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFULLY_COMPLETED), //
			@ApiResponse(code = 400, message = SwaggerMessages.BAD_REQUEST), //
			@ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN) //
	})
	@GetMapping("v1/employees")
	public ResponseEntity<?> getEmployees() {

		final var response = employeeService.getEmployees();
		return ResponseEntity.ok(response);
	}
	
}
