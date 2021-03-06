package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	private String bic;
	private String bankname;
	
	public Bank() {
		
	}
	public Bank(String bic, String bankname) {
		this.bic = bic;
		this.bankname = bankname;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getbankname() {
		return bankname;
	}

	public void setbankname(String bankname) {
		this.bankname = bankname;
	}

	@Override
	public String toString() {
		return "Bank [bic=" + bic + ", bankname=" + bankname + "]";
	}
}
