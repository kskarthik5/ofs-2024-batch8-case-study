package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_slips")
public class BankSlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slip_id")
	private int slipId;
}
