package com.ofss.main.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	@Procedure(name="createAccount")
	Map<String,Object> createAccount(int customerId,String accountType);
	@Query("SELECT a from Account a WHERE a.customer.customerId=?1")
	List<Account> findByCustomerId(int customerId);
}
