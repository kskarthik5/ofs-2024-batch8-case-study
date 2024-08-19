package com.ofss.main.domain;


import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="login_sessions")
public class LoginSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id")
	private int sessionId;
	@Column(name = "start_time", insertable = false, updatable = false)
	private Timestamp startTime;
	@Column(name = "end_time", insertable = false, updatable = false)
	private Timestamp endTime;
	@Column(name = "session_token")
	private String sessionToken;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;
	@Override
	public String toString() {
		return "LoginSession [sessionId=" + sessionId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", sessionToken=" + sessionToken + ", customer=" + customer + "]";
	}
}
