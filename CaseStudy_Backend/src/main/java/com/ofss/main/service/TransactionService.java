package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Transaction;

public interface TransactionService {
	Transaction deposit(Account account,double amount);
	Transaction withdraw(Account account,double amount);
	Transaction transfer(Account payerAccount,Account payeeAccount,double amount);
	List<Transaction> getAll(Account account);
}
