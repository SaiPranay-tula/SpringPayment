package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	private String currencycode;
	private String currencyname;
	private float conversionrate;
	
	public Currency() 	{
		
	}
	public Currency(String currencycode, String currencyname, float conversionrate) {
		this.currencycode = currencycode;
		this.currencyname = currencyname;
		this.conversionrate = conversionrate;
	}
	public String getcurrencycode() {
		return currencycode;
	}
	public void setcurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public String getcurrencyname() {
		return currencyname;
	}
	public void setcurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public float getConversionrate() {
		return conversionrate;
	}
	public void setConversionrate(float conversionrate) {
		this.conversionrate = conversionrate;
	}
	@Override
	public String toString() {
		return "Currency [currencycode=" + currencycode + ", currencyname=" + currencyname + ", conversionrate="
				+ conversionrate + "]";
	}
	

}
