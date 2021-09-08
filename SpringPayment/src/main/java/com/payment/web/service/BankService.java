package com.payment.web.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Bank;
import com.payment.web.beans.Customer;
import com.payment.web.repository.BankRepository;

@Service
public class BankService {
	public BankService() {
		
	}
	@Autowired
	private BankRepository repo;
	
	public Bank findBankByBIC(String id) {
		try {
			Optional<Bank> prod = this.repo.findById(id);

			return prod.orElseThrow(()->{
	
				return new EntityNotFoundException("Bank with "+id + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	
}
