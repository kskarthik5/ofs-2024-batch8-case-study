package com.ofss.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.repository.ChequeRepository;
import com.ofss.main.service.ChequeService;

@Service
public class ChequeServiceImpl implements ChequeService {
	@Autowired
	private ChequeRepository chequeRepository;
	@Override
	public void generateCheques(Account account, int count) {
		chequeRepository.generateCheques(account.getAccountId(), count);
	}

}
