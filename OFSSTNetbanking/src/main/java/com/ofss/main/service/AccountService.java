package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

public interface AccountService {
	Account openAccount(Customer customer,String accountType);
	List<Account> getAccounts(Customer customer);
}
