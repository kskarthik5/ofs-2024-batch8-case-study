package com.ofss.main.domain;

import java.sql.Timestamp;

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

@NamedStoredProcedureQuery(name = "deposit", procedureName = "P_DEPOSIT", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "amount", type = Double.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "message", type = String.class) })
@NamedStoredProcedureQuery(name = "withdraw", procedureName = "P_WITHDRAW", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "accountId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "amount", type = Double.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "message", type = String.class) })
@NamedStoredProcedureQuery(name = "transfer", procedureName = "P_TRANSFER", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "payerAccountId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "payeeAccountId", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "amount", type = Double.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "message", type = String.class) })

@Entity
@Table(name="transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	@ManyToOne
    @JoinColumn(name = "payer_id")
    Account payerAccount;
	@ManyToOne
    @JoinColumn(name = "payee_id")
    Account payeeAccount;
	@Column(name = "status")
    int status;
	@Column(name = "message")
    String message;
	@Column(name = "amount")
    double amount;
	@Column(name = "timestamp")
	private Timestamp timestamp;
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", payerAccount=" + payerAccount + ", payeeAccount="
				+ payeeAccount + ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	public Transaction(int transactionId, Account payerAccount, Account payeeAccount, double amount) {
		super();
		this.transactionId = transactionId;
		this.payerAccount = payerAccount;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}
	public Transaction() {
		super();
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Account getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(Account payerAccount) {
		this.payerAccount = payerAccount;
	}
	public Account getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(Account payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
