package com.payment.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Currency;
import com.payment.web.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyRepository res;
	
	public Currency findById(String code) {
		
		Optional<Currency> c= this.res.findById(code);
		return c.get();
	}
	
	

}
