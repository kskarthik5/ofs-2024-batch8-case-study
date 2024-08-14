package com.ofss.main.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
@NamedStoredProcedureQuery(name = "createAccount",
procedureName = "P_CREATE_ACCOUNT", parameters = {
@StoredProcedureParameter(mode = ParameterMode.IN, name = "customerId", type = Integer.class),
@StoredProcedureParameter(mode = ParameterMode.IN, name = "accountType", type = String.class),
@StoredProcedureParameter(mode = ParameterMode.OUT, name = "status", type = Integer.class),
@StoredProcedureParameter(mode = ParameterMode.OUT, name = "message", type = String.class),
@StoredProcedureParameter(mode = ParameterMode.OUT, name = "accountId", type = Integer.class)})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	@Column(name = "balance")
	private double balance;
	@Column(name = "min_balance")
	private double minBalance;
	@Column(name = "rate_of_interest")
	private float rateOfInterest;
	@Column(name = "interest_date")
	private Date interestDate;
	@Column(name = "interest_period")
	private int interestPeriod;
	@Column(name = "status")
	private String status="Active";
	@Column(name = "account_type")
	private String AccountType;
	@ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", minBalance=" + minBalance
				+ ", rateOfInterest=" + rateOfInterest + ", interestDate=" + interestDate + ", interestPeriod="
				+ interestPeriod + ", status=" + status + ", AccountType=" + AccountType + "]";
	}
	public Account() {
		super();
	}
	public Account(int accountId, double balance, double minBalance, float rateOfInterest, Date interestDate,
			int interestPeriod, String status, String accountType, Customer customer) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.minBalance = minBalance;
		this.rateOfInterest = rateOfInterest;
		this.interestDate = interestDate;
		this.interestPeriod = interestPeriod;
		this.status = status;
		AccountType = accountType;
		this.customer = customer;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Date getInterestDate() {
		return interestDate;
	}
	public void setInterestDate(Date interestDate) {
		this.interestDate = interestDate;
	}
	public int getInterestPeriod() {
		return interestPeriod;
	}
	public void setInterestPeriod(int interestPeriod) {
		this.interestPeriod = interestPeriod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
