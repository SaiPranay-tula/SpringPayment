package com.payment.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Bank;
import com.payment.web.repository.BankRepository;

@Service
public class BankService {
	public BankService() {

	}

	@Autowired
	private BankRepository repo;

	public Bank findBankByBIC(String id) {

		if(this.repo.findById(id).isPresent())
		return this.repo.findById(id).get();
		return null;

	}
}
