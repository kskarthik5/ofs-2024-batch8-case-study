package com.ofss.main.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	@Procedure(name="deposit")
	Map<String,Object> deposit(int accountId,double amount);
	@Procedure(name="withdraw")
	Map<String,Object> withdraw(int accountId,double amount);
	@Procedure(name="transfer")
	Map<String,Object> transfer(int payerAccountId,int payeeAccountId,double amount);
	@Query("SELECT t from Transaction t where t.payerAccount.accountId=?1 or t.payeeAccount.accountId=?1")
	List<Transaction> findAllForAccount(int accountId);
}
