package com.ofss.main.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private String status;
	@Column(name="amount",nullable = true)
	private Double amount;
	@Column (name="payee_name")
	private String payeeName;
//	@ManyToOne
//	@JoinColumn(name="account_id")
//	private Account account;
//	@ManyToOne
//	@JsonBackReference
//    @JoinColumn(name = "slip_id", nullable = false)
//    private BankSlip bankSlip;

	public Cheque() {
		super();
	}

	public Cheque(Integer chequeId, String status, Double amount, String payeeName, Account account,
			BankSlip bankSlip) {
		super();
		this.chequeId = chequeId;
		this.status = status;
		this.amount = amount;
		this.payeeName = payeeName;
//		this.account = account;
//		this.bankSlip = bankSlip;
	}

	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", status=" + status + ", amount=" + amount + ", payeeName=" + payeeName;
//				+ ", account=" + account + ", bankSlip=" + bankSlip + "]";
	}

	public Integer getChequeId() {
		return chequeId;
	}

	public void setChequeId(Integer chequeId) {
		this.chequeId = chequeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//
//	public BankSlip getBankSlip() {
//		return bankSlip;
//	}
//
//	public void setBankSlip(BankSlip bankSlip) {
//		this.bankSlip = bankSlip;
//	}
	
}
