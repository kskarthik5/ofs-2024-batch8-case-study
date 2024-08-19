package com.ofss.main.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@NamedStoredProcedureQuery(name = "validate", procedureName = "P_LOGIN_CHECK", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "username", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "status", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "message", type = String.class) })

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "username")
	private String username;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(name = "phone")
	private int phone;
	@Column(name = "status")
	private String status="Active";

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", phone=" + phone + ", status=" + status;
	}

	public Customer() {
		super();
	}

	public Customer(int customerId, String username, String firstName, String lastName, String password, int phone,
			String status, Set<Account> accounts) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
