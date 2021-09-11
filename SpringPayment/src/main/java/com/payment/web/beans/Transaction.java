package com.payment.web.beans;



import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="currencycode")
	private Currency currencycode;
	@ManyToOne
	@JoinColumn(name="senderbic")
	private Bank senderbic;
	@ManyToOne
	@JoinColumn(name="receiverbic")
	private Bank receiverbic;
	private String receiveraccountholdernumber;
	private String receiveraccountholdername;
	@ManyToOne
	@JoinColumn(name="transfertypecode")
	private TransferTypes transfertypecode;
	@ManyToOne
	@JoinColumn(name="messagecode")
	private Message messagecode;
	private double currencyamount;
	private double transferfees;
	@Column(name="date" ,insertable=false, updatable=false)
	private Date transferdate;
	
	public Date getTransferdate() {
		return transferdate;
	}

	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customerid=" + customer + ", currencycode="
				+ currencycode + ", senderbic=" + senderbic + ", receiverbic=" + receiverbic
				+ ", receiveraccounholdernumber=" + receiveraccountholdernumber + ", receiveraccounholdername="
				+ receiveraccountholdername + ", transfertypecode=" + transfertypecode + ", messagecode=" + messagecode
				+ ", currencyamount=" + currencyamount + ", transferfees=" + transferfees + ", inramount=" + inramount
				+ ", date=" + date + "]";
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Customer getCustomerid() {
		return customer;
	}

	public void setCustomerid(Customer optional) {
		this.customer = optional;
	}

	public Currency getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(Currency currencycode) {
		this.currencycode = currencycode;
	}

	public Bank getSenderbic() {
		return senderbic;
	}

	public void setSenderbic(Bank senderbic) {
		this.senderbic = senderbic;
	}

	public Bank getReceiverbic() {
		return receiverbic;
	}

	public void setReceiverbic(Bank receiverbic) {
		this.receiverbic = receiverbic;
	}

	public String getReceiveraccounholdernumber() {
		return receiveraccountholdernumber;
	}

	public void setReceiveraccounholdernumber(String receiveraccounholdernumber) {
		this.receiveraccountholdernumber = receiveraccounholdernumber;
	}

	public String getReceiveraccounholdername() {
		return receiveraccountholdername;
	}

	public void setReceiveraccounholdername(String receiveraccounholdername) {
		this.receiveraccountholdername = receiveraccounholdername;
	}

	public TransferTypes getTransfertypecode() {
		return transfertypecode;
	}

	public void setTransfertypecode(TransferTypes transfertypecode) {
		this.transfertypecode = transfertypecode;
	}

	public Message getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(Message messagecode) {
		this.messagecode = messagecode;
	}

	public double getCurrencyamount() {
		return currencyamount;
	}

	public void setCurrencyamount(double currencyamount) {
		this.currencyamount = currencyamount;
	}

	public double getTransferfees() {
		return transferfees;
	}

	public void setTransferfees(double transferfees) {
		this.transferfees = transferfees;
	}

	public double getInramount() {
		return inramount;
	}

	public void setInramount(double inramount) {
		this.inramount = inramount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	private double inramount;
	public Transaction(int transactionid, Customer customerid, Currency currencycode, Bank senderbic, Bank receiverbic,
		String receiveraccounholdernumber, String receiveraccounholdername, TransferTypes transfertypecode,
		Message messagecode, double currencyamount, double transferfees, double inramount, Date date) {
	this.transactionid = transactionid;
	this.customer = customerid;
	this.currencycode = currencycode;
	this.senderbic = senderbic;
	this.receiverbic = receiverbic;
	this.receiveraccountholdernumber = receiveraccounholdernumber;
	this.receiveraccountholdername = receiveraccounholdername;
	this.transfertypecode = transfertypecode;
	this.messagecode = messagecode;
	this.currencyamount = currencyamount;
	this.transferfees = transferfees;
	this.inramount = inramount;
	this.date = date;
}


	private Date date;
	
	public Transaction() {
		
	}

	
	
	

}
