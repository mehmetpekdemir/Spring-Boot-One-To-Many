package com.mehmetpekdemir.onetomany.service;

import java.util.List;

import com.mehmetpekdemir.onetomany.dto.response.EmployeeResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface EmployeeService {

	List<EmployeeResponse> getEmployees();

}
