package com.payment.web.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.beans.CustomerUser;
import com.payment.web.repository.CustomerRepository;
import com.payment.web.repository.CustomerUserRepository;

@Service
public class CustomerService {
	
	public CustomerService() {
		
	}
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer findCustomer(String id) {
		
		return this.repo.findById(id).get();
				
	}
	
	public boolean updateAmount(Customer customer,double amnt) {
		Optional<Customer> cust=repo.findById(customer.getcustomerid());
		if(cust!=null) {
			cust.get().setclearbalance(amnt);
			return true; 
		}
		return false;
	}

	
	}
	
	


