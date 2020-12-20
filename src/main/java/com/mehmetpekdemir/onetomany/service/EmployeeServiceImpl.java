package com.mehmetpekdemir.onetomany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.onetomany.dto.response.EmployeeResponse;
import com.mehmetpekdemir.onetomany.entity.EmployeeEntity;
import com.mehmetpekdemir.onetomany.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<EmployeeResponse> getEmployees() {
		return employeeRepository.findAll().stream() //
				.map(employee -> mapToEmployeeResponse(employee)) //
				.collect(Collectors.toList()); //
	}

	private EmployeeResponse mapToEmployeeResponse(EmployeeEntity employee) {
		return EmployeeResponse.builder() //
				.firstName(employee.getFirstName()) //
				.lastName(employee.getLastName()) //
				.build(); //
	}

}
