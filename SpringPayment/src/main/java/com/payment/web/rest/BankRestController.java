package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.beans.Bank;
import com.payment.web.service.BankService;

@RestController
@CrossOrigin()
public class BankRestController {
	
	
	@Autowired
	private BankService service;
	
	@GetMapping("/bank/{bid}")
	public Bank findBankByBID(@PathVariable String bid) {
		Bank b = null;
		try {
		b = service.findBankByBIC(bid);
		}
		catch(Exception e) {
			
		}
		return b;
		
	}

}
