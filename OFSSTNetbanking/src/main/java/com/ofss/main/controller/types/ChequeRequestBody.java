package com.ofss.main.controller.types;

import com.ofss.main.domain.Account;

public class ChequeRequestBody {
	private Account account;
	private int count;
	public ChequeRequestBody(Account account, int count) {
		super();
		this.account = account;
		this.count = count;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
