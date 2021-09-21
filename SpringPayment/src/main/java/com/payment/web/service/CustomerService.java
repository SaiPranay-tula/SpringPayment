package com.payment.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.repository.CustomerRepository;

@Service
public class CustomerService {
	
	public CustomerService() {
		
	}
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer findCustomer(String id) {
		
		
		if(this.repo.findById(id).isPresent())
		return this.repo.findById(id).get();
		return null;
				
	}
	
	public boolean updateAmount(Customer customer,double amnt) {
		Optional<Customer> cust=repo.findById(customer.getcustomerid());
		if(cust.isPresent()) {
			double total = amnt+(amnt*0.025);
			
			if(cust.get().getclearbalance()>total || cust.get().getoverdraftflag()==1) {
				double balance=cust.get().getclearbalance()-total;
			cust.get().setclearbalance(balance);
			
			return true;
			}
			return false;
		}
		return false;
	}

	
	}
	
	


