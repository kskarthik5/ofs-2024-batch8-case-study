package com.ofss.main.controller.types;

import com.ofss.main.domain.Account;

public class DepositWithdrawRequestBody {
	private Account account;
	private double amount;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public DepositWithdrawRequestBody() {
		super();
	}
	public DepositWithdrawRequestBody(Account account, double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
}
