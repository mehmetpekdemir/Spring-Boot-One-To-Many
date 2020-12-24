package com.mehmetpekdemir.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_number", nullable = false, length = 20, unique = true)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private EmployeeEntity employee;

	public AccountEntity(String accountNumber, EmployeeEntity employee) {
		this.accountNumber = accountNumber;
		this.employee = employee;
	}

}
