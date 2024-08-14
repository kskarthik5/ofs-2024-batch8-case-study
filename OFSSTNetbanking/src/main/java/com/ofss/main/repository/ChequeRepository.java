package com.ofss.main.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Cheque;

public interface ChequeRepository extends CrudRepository<Cheque, Integer> {
	@Procedure(name="generateCheques")
	void generateCheques(int accountId,int count);
}
