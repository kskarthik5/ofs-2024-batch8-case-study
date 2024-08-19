package com.ofss.main.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_slips")
public class BankSlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slip_id")
	private int slipId;
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
//	@JsonManagedReference
//	@OneToMany(mappedBy="bankSlip",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Cheque> cheques;
	@Column(name="status")
	private String status;

	public BankSlip(int slipId, Account account, List<Cheque> cheques, String status) {
		super();
		this.slipId = slipId;
		this.account = account;
		this.status = status;
//		this.cheques=cheques;
	}
	@Override
	public String toString() {
		return "BankSlip [slipId=" + slipId + ", account=" + account + ", status=" + status
				+ "]";
	}
	public BankSlip() {
		super();
	}
	public int getSlipId() {
		return slipId;
	}
	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
//	public List<Cheque> getCheques() {
//		return cheques;
//	}
//	public void setCheques(List<Cheque> cheques) {
//		this.cheques = cheques;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public void addCheque(Cheque cheque) {
//		 this.cheques.add(cheque);
//		 cheque.setBankSlip(this);
//	}
}
