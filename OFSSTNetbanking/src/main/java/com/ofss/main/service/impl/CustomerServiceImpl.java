package com.ofss.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.CustomerService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

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
		   StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("P_LOGIN_CHECK");
	        storedProcedureQuery.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	        storedProcedureQuery.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
	        storedProcedureQuery.registerStoredProcedureParameter(4,String.class, ParameterMode.OUT);
	        storedProcedureQuery.setParameter(1, username);
	        storedProcedureQuery.setParameter(2, password);
	        Map<String,Object> map=new HashMap<String, Object>();
	        map.put("status", (Integer)storedProcedureQuery.getOutputParameterValue(3));
	        map.put("message", (String)storedProcedureQuery.getOutputParameterValue(4));
	        return map;
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
