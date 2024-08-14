package com.ofss.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.CustomerRepository;

@SpringBootTest
class OfsstNetbankingApplicationTests {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Test
	void contextLoads() {
	}
	
	@Test
	void testAccountRepository() {
		System.out.println(customerRepository.validate("jdoe", "password123"));
	}
	

}
