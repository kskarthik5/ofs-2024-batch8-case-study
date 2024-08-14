package com.ofss.main.controller.types;

import com.ofss.main.domain.Account;

public class DepositWithdrawRequest {
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
	public DepositWithdrawRequest() {
		super();
	}
	public DepositWithdrawRequest(Account account, double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
}
