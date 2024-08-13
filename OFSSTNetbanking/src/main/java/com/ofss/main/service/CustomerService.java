package com.ofss.main.service;

import java.util.List;
import java.util.Map;

import com.ofss.main.domain.Customer;
public interface CustomerService {
	public Map<String,Object> validate(String username,String password);

	List<Customer> getAll();
	Customer getById(int customerId);
	Customer register(Customer customer);
	Customer update(Customer customer);
	boolean delete(int customerId);
}
