package com.mehmetpekdemir.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.onetomany.entity.EmployeeEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
