package com.ofss.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.BankSlip;
import com.ofss.main.domain.Cheque;
import com.ofss.main.repository.BankSlipRepository;
import com.ofss.main.repository.ChequeRepository;
import com.ofss.main.service.BankSlipService;

@Service
public class BankSlipServiceImpl implements BankSlipService{
	@Autowired
	BankSlipRepository bankSlipRepository;
	@Autowired
	ChequeRepository chequeRepository;
	@Override
	public BankSlip get(int slipId) {
		return bankSlipRepository.findById(slipId).orElse(null);
	}

	@Override
	public List<BankSlip> getByAccount(Account account) {
		return bankSlipRepository.findAllByAccountId(account.getAccountId());
	}

	@Override
	public BankSlip create(BankSlip bankSlip) {
		return bankSlipRepository.save(bankSlip);
	}

	@Override
	public BankSlip addCheque(BankSlip bankSlip, Cheque cheque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankSlip addCheques(BankSlip bankSlip, List<Cheque> cheques) {
		// TODO Auto-generated method stub
		return null;
	}

}
