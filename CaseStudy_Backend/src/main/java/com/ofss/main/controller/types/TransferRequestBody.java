package com.ofss.main.controller.types;

import com.ofss.main.domain.Account;

public class TransferRequestBody {
	private Account payer;
	private Account payee;
	private double amount;
	public TransferRequestBody() {
		super();
	}
	public TransferRequestBody(Account payer, Account payee, double amount) {
		super();
		this.payer = payer;
		this.payee = payee;
		this.amount = amount;
	}
	public Account getPayer() {
		return payer;
	}
	public void setPayer(Account payer) {
		this.payer = payer;
	}
	public Account getPayee() {
		return payee;
	}
	public void setPayee(Account payee) {
		this.payee = payee;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
