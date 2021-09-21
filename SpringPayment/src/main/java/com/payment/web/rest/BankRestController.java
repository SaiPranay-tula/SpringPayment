package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> findBankByBID(@PathVariable String bid) {
		Bank b = service.findBankByBIC(bid);
		if(b!=null) {
		    return ResponseEntity.ok().body(b);
		} else {
			return new ResponseEntity<>("BID not found",HttpStatus.NOT_FOUND);
				}
		
	
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Security";
	}

}

