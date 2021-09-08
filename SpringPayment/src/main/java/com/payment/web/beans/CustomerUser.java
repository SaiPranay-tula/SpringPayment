package com.payment.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customeruser")
public class CustomerUser {
	 
	@Id 
	@Column(name="userid")
	private int userId;
	@Column(name="username",unique = true)
	private String username;
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	@Column(name="userpassword")
	private String userPassword;
	public CustomerUser() {
		
	}
	public CustomerUser(int userId, String username, Customer customerId, String userPassword) {
		this.userId = userId;
		this.username = username;
		this.customer = customerId;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "CustomerUser [userId=" + userId + ", username=" + username + ", customerId=" + customer
				+ ", userPassword=" + userPassword + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public Customer getCustomerId() {
		return customer;
	}
	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
