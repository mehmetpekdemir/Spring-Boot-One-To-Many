package com.mehmetpekdemir.onetomany.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.onetomany.entity.AccountEntity;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	Optional<AccountEntity> findByAccountNumber(String accountNumber);

	boolean existsAccountByAccountNumber(String accountNumber);

}
