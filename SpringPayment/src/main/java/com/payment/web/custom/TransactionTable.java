package com.payment.web.custom;

import java.util.Date;

public class TransactionTable {
private	String receiveraccounholdername;
private	String receiveraccounholdernumber;
private	String bankName;
private	Date transferdate;
@Override
public String toString() {
	return "TransactionTable [receiveraccounholdername=" + receiveraccounholdername + ", receiveraccounholdernumber="
			+ receiveraccounholdernumber + ", bankName=" + bankName + ", transferdate=" + transferdate
			+ ", currencyamount=" + currencyamount + "]";
}
public TransactionTable(String receiveraccounholdername, String receiveraccounholdernumber, String bankName,
		Date transferdate, Double currencyamount) {
	this.receiveraccounholdername = receiveraccounholdername;
	this.receiveraccounholdernumber = receiveraccounholdernumber;
	this.bankName = bankName;
	this.transferdate = transferdate;
	this.currencyamount = currencyamount;
}
public String getReceiveraccounholdername() {
	return receiveraccounholdername;
}
public void setReceiveraccounholdername(String receiveraccounholdername) {
	this.receiveraccounholdername = receiveraccounholdername;
}
public String getReceiveraccounholdernumber() {
	return receiveraccounholdernumber;
}
public void setReceiveraccounholdernumber(String receiveraccounholdernumber) {
	this.receiveraccounholdernumber = receiveraccounholdernumber;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public Date getTransferdate() {
	return transferdate;
}
public void setTransferdate(Date transferdate) {
	this.transferdate = transferdate;
}
public Double getCurrencyamount() {
	return currencyamount;
}
public void setCurrencyamount(Double currencyamount) {
	this.currencyamount = currencyamount;
}
private	Double currencyamount;

}
