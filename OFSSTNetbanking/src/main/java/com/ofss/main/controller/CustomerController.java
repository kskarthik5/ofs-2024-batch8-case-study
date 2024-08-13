package com.ofss.main.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.service.CustomerService;
import com.ofss.main.types.LoginCredentials;
@CrossOrigin(origins="*")
@RequestMapping("api/customer")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository customerRepository;
	@GetMapping("getAll")
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	@GetMapping("get/{id}")
	public Customer get(@PathVariable(value="id") int customerId){
		return customerService.getById(customerId);
	}
	@PostMapping("login")
	public Map<String,Object> login(@RequestBody Customer customer) {
		return customerRepository.validate(customer.getUsername(), customer.getPassword());
	}
	@PostMapping("register")
	public Customer register(@RequestBody Customer customer) {
		return customerService.register(customer);
	}
	@PutMapping("update")
	public Customer update(@RequestBody Customer customer) {
		return customerService.update(customer);
	}
	@GetMapping("delete/{id}")
	public boolean delete(@PathVariable(value="id") int customerId){
		return customerService.delete(customerId);
	}
}
