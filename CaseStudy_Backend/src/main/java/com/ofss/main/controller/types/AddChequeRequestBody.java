package com.ofss.main.controller.types;

import com.ofss.main.domain.BankSlip;
import com.ofss.main.domain.Cheque;

public class AddChequeRequestBody {
	private BankSlip bankSlip;
	private Cheque cheque;
	public AddChequeRequestBody(BankSlip bankSlip, Cheque cheque) {
		super();
		this.bankSlip = bankSlip;
		this.cheque = cheque;
	}
	public AddChequeRequestBody() {
		super();
	}

	public BankSlip getBankSlip() {
		return bankSlip;
	}
	public void setBankSlip(BankSlip bankSlip) {
		this.bankSlip = bankSlip;
	}
	public Cheque getCheque() {
		return cheque;
	}
	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}
}
