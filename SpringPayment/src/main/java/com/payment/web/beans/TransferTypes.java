package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transfertypes")
public class TransferTypes {
	@Id
	private char transfertypecode;
	private String transfertypedescription;
	public char gettransfertypecode() {
		return transfertypecode;
	}
	public TransferTypes() {
		
	}
	public TransferTypes(char transfertypecode, String transfertypedescription) {
		this.transfertypecode = transfertypecode;
		this.transfertypedescription = transfertypedescription;
	}
	public void settransfertypecode(char transfertypecode) {
		this.transfertypecode = transfertypecode;
	}
	public String gettransfertypedescription() {
		return transfertypedescription;
	}
	public void settransfertypedescription(String transfertypedescription) {
		this.transfertypedescription = transfertypedescription;
	}
	@Override
	public String toString() {
		return "TransferTypes [transfertypecode=" + transfertypecode + ", transfertypedescription="
				+ transfertypedescription + "]";
	}
	
	

}
