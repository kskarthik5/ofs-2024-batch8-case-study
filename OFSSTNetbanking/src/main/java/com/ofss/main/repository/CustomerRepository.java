package com.ofss.main.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.main.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Procedure(name="validate")
	Map<String,Object> validate(String username,String password);
}
