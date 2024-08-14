package com.ofss.main.domain;

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
@Table(name="cheques")
@NamedStoredProcedureQuery(name = "generateCheques", procedureName = "P_GENERATE_CHEQUES", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "count", type = Integer.class)})

public class Cheque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cheque_id")
	private int chequeId;
	@Column(name="status")
	private String status="Issued";
	@Column(name="amount")
	private double amount;
	@Column (name="payee")
	private String payeeName;
	@ManyToOne
	@JoinColumn(name="slip_id")
	private BankSlip bankSlip;
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", status=" + status + ", amount=" + amount + ", payeeName=" + payeeName
				+ ", bankSlip=" + bankSlip + ", account=" + account + "]";
	}
	public Cheque() {
		super();
	}
	public Cheque(int chequeId, String status, double amount, String payeeName, BankSlip bankSlip, Account account) {
		super();
		this.chequeId = chequeId;
		this.status = status;
		this.amount = amount;
		this.payeeName = payeeName;
		this.bankSlip = bankSlip;
		this.account = account;
	}
	public int getChequeId() {
		return chequeId;
	}
	public void setChequeId(int chequeId) {
		this.chequeId = chequeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public BankSlip getBankSlip() {
		return bankSlip;
	}
	public void setBankSlip(BankSlip bankSlip) {
		this.bankSlip = bankSlip;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
