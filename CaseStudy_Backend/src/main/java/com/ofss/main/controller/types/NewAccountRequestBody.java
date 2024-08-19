package com.ofss.main.controller.types;

import com.ofss.main.domain.Customer;

public class NewAccountRequestBody {
		private Customer customer;
		private String accountType;
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public NewAccountRequestBody(Customer customer, String accountType) {
			super();
			this.customer = customer;
			this.accountType = accountType;
	}
}
