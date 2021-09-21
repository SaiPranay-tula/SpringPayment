package com.payment.web.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.beans.CustomerUser;
import com.payment.web.repository.CustomerUserRepository;

@Service
public class CustomerUserService implements UserDetailsService {
	
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

	public Customer login(String obj) {
		try {
		CustomerUser user = findCustomerUserByName(obj);
		
			return user.getCustomerId();
		
		}
		catch(Exception e) {
			
		}
		
		return null;

}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<CustomerUser> user = repo.findByUsername(username);
		CustomerUser users=user.get();
		return new User(users.getusername(),users.getUserPassword(),new ArrayList<>());
	}
}
