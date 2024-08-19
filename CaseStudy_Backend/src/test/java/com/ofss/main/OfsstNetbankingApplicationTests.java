package com.ofss.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.BankSlipRepository;
import com.ofss.main.repository.ChequeRepository;
import com.ofss.main.repository.CustomerRepository;

@SpringBootTest
class OfsstNetbankingApplicationTests {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ChequeRepository chequeRepository;
	@Autowired
	BankSlipRepository bankSlipRepository;
	@Test
	void contextLoads() {
	}
	
	@Test
	void testAccountRepository() {
		System.out.println(accountRepository.findById(100001));
		System.out.println(customerRepository.findById(100001));
		System.out.println(chequeRepository.findById(10000001));
		System.out.println(bankSlipRepository.findById(1000001));
	}
	

}
