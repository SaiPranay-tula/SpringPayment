package com.payment.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.web.beans.Logger;
import com.payment.web.repository.LoggerRepository;

public class LoggerService {
	
	@Autowired
	LoggerRepository repo;
	
	public boolean insertToLogger(Logger log) {
		
		if(repo.save(log).getipaddress() !=null)
		{
			return true;
		}
		return false;
	}

}
