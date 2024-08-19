package com.ofss.main.service;

import com.ofss.main.domain.Account;

public interface ChequeService {
	void generateCheques(Account account,int count);
}
