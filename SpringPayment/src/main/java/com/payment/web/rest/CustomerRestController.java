package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.beans.Customer;
import com.payment.web.custom.CustomerTable;
import com.payment.web.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerRestController {
	
	@Autowired
	private CustomerService cus_service;
	
	@GetMapping("/customer/{cid}")
	public CustomerTable findCustomer( 
			@PathVariable String cid
			)
	{
		CustomerTable cust=null;
		try {
			Customer c = cus_service.findCustomer(cid);
		cust=new CustomerTable(c.getcustomerid(),
				c.getaccountholdername(),c.getclearbalance(),c.getoverdraftflag());
		}
		catch(Exception e) {
			
			return null;
			
		}
		return cust;
		
	}
	
	@GetMapping("/customer_name/{name}")
	public boolean checkList(
			@PathVariable String cust_name)
	{
		return false;
	}
	
	
	
	
	
	

}
