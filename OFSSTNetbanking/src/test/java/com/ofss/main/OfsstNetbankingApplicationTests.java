package com.ofss.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ofss.main.repository.AccountRepository;

@SpringBootTest
class OfsstNetbankingApplicationTests {
	@Autowired
	AccountRepository accountRepository;
	@Test
	void contextLoads() {
	}
	
	@Test
	void testAccountRepository() {
		System.out.println(accountRepository.createAccount(100002, "Savings"));
	}
	

}
