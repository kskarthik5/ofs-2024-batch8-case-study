package com.ofss.main.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

public interface AccountRepository extends CrudRepository<Account, Integer>{
	@Procedure(name="createAccount")
	Map<String,Object> createAccount(int customerId,String accountType);
}
