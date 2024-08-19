package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.BankSlip;

public interface BankSlipRepository extends CrudRepository<BankSlip, Integer>{
	@Query("SELECT b FROM BankSlip b WHERE b.account.accountId=?1")
	List<BankSlip> findAllByAccountId(int accountId);
}
