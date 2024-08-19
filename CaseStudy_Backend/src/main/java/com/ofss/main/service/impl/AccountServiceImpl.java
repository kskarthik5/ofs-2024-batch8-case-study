package com.ofss.main.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	@Override
	public Account openAccount(Customer customer, String accountType) {
		Map<String,Object> res=accountRepository.createAccount(customer.getCustomerId(), accountType);
		return accountRepository.findById((int)res.get("accountId")).orElse(null);
	}
	@Override
	public List<Account> getAccounts(Customer customer) {
		return accountRepository.findByCustomerId(customer.getCustomerId());
	}

}
