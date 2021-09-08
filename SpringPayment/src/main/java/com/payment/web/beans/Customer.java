package com.payment.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="customerid")
	private String customerid;
	private String accountholdername;
	private byte overdraftflag;
	private double clearbalance;
	private String customeraddress;
	private String customercity;
	private char customertype;
	public Customer()
	{
		
	}
	public Customer(String customerid, String accountholdername, byte overdraftflag, double clearbalance,
			String customeraddress, String customercity, char customertype) {
		
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraftflag = overdraftflag;
		this.clearbalance = clearbalance;
		this.customeraddress = customeraddress;
		this.customercity = customercity;
		this.customertype = customertype;
	}
	public String getcustomerid() {
		return customerid;
	}
	public void setcustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getaccountholdername() {
		return accountholdername;
	}
	public void setaccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public byte getoverdraftflag() {
		return overdraftflag;
	}
	public void setoverdraftflag(byte overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	public double getclearbalance() {
		return clearbalance;
	}
	public void setclearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}
	public String getcustomeraddress() {
		return customeraddress;
	}
	public void setcustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getcustomercity() {
		return customercity;
	}
	public void setcustomercity(String customercity) {
		this.customercity = customercity;
	}
	public char getcustomertype() {
		return customertype;
	}
	public void setcustomertype(char customertype) {
		this.customertype = customertype;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraftflag="
				+ overdraftflag + ", clearbalance=" + clearbalance + ", customeraddress=" + customeraddress
				+ ", customercity=" + customercity + ", customertype=" + customertype + "]";
	}
	

}
