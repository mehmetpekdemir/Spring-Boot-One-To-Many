package com.mehmetpekdemir.onetomany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mehmetpekdemir.onetomany.entity.AccountEntity;
import com.mehmetpekdemir.onetomany.entity.EmployeeEntity;
import com.mehmetpekdemir.onetomany.repository.AccountRepository;
import com.mehmetpekdemir.onetomany.repository.EmployeeRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialData(EmployeeRepository employeeRepository,AccountRepository accountRepository) {
		return (args) -> {
			EmployeeEntity employee = new EmployeeEntity("Mehmet123","Mehmet", "Pekdemir");
			employeeRepository.save(employee);
			accountRepository.save(new AccountEntity("12345678910", employee));
		};
	}
}
