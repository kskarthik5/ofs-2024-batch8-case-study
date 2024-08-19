package com.ofss.main.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.CustomerService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomerServiceImpl implements CustomerService{
	@PersistenceContext EntityManager entityManager;
	@Autowired
	CustomerRepository customerRepository;
	@Override
	public List<Customer> getAll(){
		return (List<Customer>) customerRepository.findAll();
	}
	@Override
	public Map<String, Object> validate(String username, String password) {
		   Map<String,Object> res=customerRepository.validate(username, password);
		   res.put("data", customerRepository.findByUsername(username));
	       return res;
	}
	@Override
	public Customer getById(int customerId) {
		Optional<Customer> customer=customerRepository.findById(customerId);
		if(customer.isPresent())
			return customer.get();
		return null;
	}
	@Override
	public Customer register(Customer customer) {
		return customerRepository.save(customer);
	}
	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	@Override
	public boolean delete(int customerId) {
		if(!customerRepository.findById(customerId).isPresent()) return false;
		customerRepository.deleteById(customerId);
		return true;
	}
}
