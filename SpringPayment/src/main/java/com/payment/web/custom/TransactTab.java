package com.payment.web.custom;

public class TransactTab {
	
	private String customerid;
	private String receiverBic;
	private String raccountname;
	private String raccountnumber;
	private String transfertype;
	private String messagecode;
	private double inramount;
	private double transferfee;
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getReceiverBic() {
		return receiverBic;
	}
	public void setReceiverBic(String receiverBic) {
		this.receiverBic = receiverBic;
	}
	public String getRaccountname() {
		return raccountname;
	}
	public void setRaccountname(String raccountname) {
		this.raccountname = raccountname;
	}
	public String getRaccountnumber() {
		return raccountnumber;
	}
	public void setRaccountnumber(String raccountnumber) {
		this.raccountnumber = raccountnumber;
	}
	public String getTransfertype() {
		return transfertype;
	}
	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}
	public String getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}
	public double getInramount() {
		return inramount;
	}
	public void setInramount(double inramount) {
		this.inramount = inramount;
	}
	public double getTransferfee() {
		return transferfee;
	}
	public void setTransferfee(double transferfee) {
		this.transferfee = transferfee;
	}
	@Override
	public String toString() {
		return "TransactTab [customerid=" + customerid + ", receiverBic=" + receiverBic + ", raccountname="
				+ raccountname + ", raccountnumber=" + raccountnumber + ", transfertype=" + transfertype
				+ ", messagecode=" + messagecode + ", inramount=" + inramount + ", transferfee=" + transferfee + "]";
	}
	public TransactTab(String customerid, String receiverBic, String raccountname, String raccountnumber,
			String transfertype, String messagecode, double inramount, double transferfee) {
		this.customerid = customerid;
		this.receiverBic = receiverBic;
		this.raccountname = raccountname;
		this.raccountnumber = raccountnumber;
		this.transfertype = transfertype;
		this.messagecode = messagecode;
		this.inramount = inramount;
		this.transferfee = transferfee;
	}
	public TransactTab() {
		
	}
	
}
