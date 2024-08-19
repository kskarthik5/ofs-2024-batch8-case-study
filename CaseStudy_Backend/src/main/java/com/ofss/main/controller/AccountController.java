package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.controller.types.NewAccountRequestBody;
import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.service.AccountService;

@CrossOrigin(origins="*")
@RequestMapping("api/account")
@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	@PostMapping("open")
	public Account open(@RequestBody NewAccountRequestBody body) {
		return accountService.openAccount(body.getCustomer(),body.getAccountType());
	}
	@PostMapping("get")
	public List<Account> getAccounts(@RequestBody Customer customer) {
		return accountService.getAccounts(customer);
	}
}
