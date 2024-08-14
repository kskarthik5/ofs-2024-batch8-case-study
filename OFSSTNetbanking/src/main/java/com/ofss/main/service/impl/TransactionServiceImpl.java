package com.ofss.main.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Transaction;
import com.ofss.main.repository.AccountRepository;
import com.ofss.main.repository.TransactionRepository;
import com.ofss.main.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;
	@Override
	public Transaction deposit(Account account, double amount) {
		Map<String,Object> res=transactionRepository.deposit(account.getAccountId(), amount);
		Transaction newT=new Transaction();
		newT.setPayeeAccount(accountRepository.findById(account.getAccountId()).orElse(null));
		newT.setAmount(amount);
		newT.setStatus((Integer)res.get("status"));
		newT.setMessage((String)res.get("message"));
		return transactionRepository.save(newT);
	}

	@Override
	public Transaction withdraw(Account account, double amount) {
		Map<String,Object> res=transactionRepository.withdraw(account.getAccountId(), amount);
		Transaction newT=new Transaction();
		newT.setPayeeAccount(accountRepository.findById(account.getAccountId()).orElse(null));
		newT.setAmount(amount);
		newT.setStatus((Integer)res.get("status"));
		newT.setMessage((String)res.get("message"));
		return transactionRepository.save(newT);
	}

	@Override
	public Transaction transfer(Account payerAccount, Account payeeAccount, double amount) {
		Map<String,Object> res=transactionRepository.transfer(payerAccount.getAccountId(),payeeAccount.getAccountId(), amount);
		Transaction newT=new Transaction();
		newT.setPayerAccount(accountRepository.findById(payerAccount.getAccountId()).orElse(null));
		newT.setPayeeAccount(accountRepository.findById(payeeAccount.getAccountId()).orElse(null));
		newT.setAmount(amount);
		newT.setStatus((Integer)res.get("status"));
		newT.setMessage((String)res.get("message"));
		return transactionRepository.save(newT);
	}

	@Override
	public List<Transaction> getAll(Account account) {
		return transactionRepository.findAllForAccount(account.getAccountId());
	}

}
