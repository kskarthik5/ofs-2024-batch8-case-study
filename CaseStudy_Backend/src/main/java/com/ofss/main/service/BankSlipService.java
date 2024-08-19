package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.BankSlip;
import com.ofss.main.domain.Cheque;

public interface BankSlipService {
	BankSlip get(int slipId);
	List<BankSlip> getByAccount(Account account);
	BankSlip create(BankSlip bankSlip);
	BankSlip addCheque(BankSlip bankSlip,Cheque cheque);
	BankSlip addCheques(BankSlip bankSlip,List<Cheque> cheques);
}
