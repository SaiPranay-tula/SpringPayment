package com.payment.web.custom;

public class CustomerTable {
	private String customerId;
	private String customerName;
	private double clearBalance;
	private byte overdraftflag;
	
	public CustomerTable(String customerId, String customerName, double clearBalance, byte overdraftflag) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.clearBalance = clearBalance;
		this.overdraftflag = overdraftflag;
	}
	public byte getOverdraftflag() {
		return overdraftflag;
	}
	public void setOverdraftflag(byte overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	@Override
	public String toString() {
		return "CustomerTable [customerId=" + customerId + ", customerName=" + customerName + ", clearBalance="
				+ clearBalance + ", overdraftflag=" + overdraftflag + "]";
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getClearBalance() {
		return clearBalance;
	}
	public void setClearBalance(double clearBalance) {
		this.clearBalance = clearBalance;
	}

}
