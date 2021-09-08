package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Logger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loggerid;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customerid;
	@ManyToOne
	@JoinColumn(name="userid")
	private CustomerUser userid;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employeeid;
	private String screenname;
	private String action;
	private String ipaddress;
	
	public Logger() {
		
	}
	public Logger(int loggerid, Customer customerid, CustomerUser userid, Employee employeeid, String screenname, String action,
			String ipaddress) {
		this.loggerid = loggerid;
		this.customerid = customerid;
		this.userid = userid;
		this.employeeid = employeeid;
		this.screenname = screenname;
		this.action = action;
		this.ipaddress = ipaddress;
	}
	public int getloggerid() {
		return loggerid;
	}
	public void setloggerid(int loggerid) {
		this.loggerid = loggerid;
	}
	public Customer getcustomerid() {
		return customerid;
	}
	public void setcustomerid(Customer customerid) {
		this.customerid = customerid;
	}
	public CustomerUser getuserid() {
		return userid;
	}
	public void setuserid(CustomerUser userid) {
		this.userid = userid;
	}
	public Employee getemployeeid() {
		return employeeid;
	}
	public void setemployeeid(Employee employeeid) {
		this.employeeid = employeeid;
	}
	public String getscreenname() {
		return screenname;
	}
	public void setscreenname(String screenname) {
		this.screenname = screenname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getipaddress() {
		return ipaddress;
	}
	public void setipaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	@Override
	public String toString() {
		return "Logger [loggerid=" + loggerid + ", customerid=" + customerid + ", userid=" + userid + ", employeeid="
				+ employeeid + ", screenname=" + screenname + ", action=" + action + ", ipaddress=" + ipaddress + "]";
	}
	

}
