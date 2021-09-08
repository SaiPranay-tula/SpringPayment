package com.payment.web.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.beans.CustomerUser;
import com.payment.web.repository.CustomerUserRepository;

@Service
public class CustomerUserService {
	
	public CustomerUserService() {
		
	}
	@Autowired
	private CustomerUserRepository repo;
	
	public CustomerUser findCustomerUserByName(String username) {
		try {
			Optional<CustomerUser> prod = this.repo.findByUsername(username);

			return prod.orElseThrow(()->{
	
				return new EntityNotFoundException("Customer User with "+username + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}

	public Customer login(CustomerUser obj) {
		try {
		CustomerUser user = findCustomerUserByName(obj.getusername());
		if(obj.getUserPassword().equals(user.getUserPassword()))
		{
			return user.getCustomerId();
		}
		}
		catch(Exception e) {
			
		}
		
		return null;

}
}
