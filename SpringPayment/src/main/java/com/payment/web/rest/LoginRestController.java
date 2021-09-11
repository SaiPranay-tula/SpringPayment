package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.beans.Customer;
import com.payment.web.beans.CustomerUser;
import com.payment.web.service.CustomerUserService;

@RestController
@CrossOrigin()
public class LoginRestController {

	@Autowired
	private CustomerUserService service;
	


//	
//	public CustomerUser findCustomers(@PathVariable Object user ){
//		return this.service.findCustomerUserByName("User");
//		
//	}
//	@PostMapping("/login")
//	public ResponseEntity<String> insertProduct(@RequestBody CustomerUser cust)
//	{
//		
//		System.out.println(cust);
//			return  ResponseEntity
//					.status(HttpStatus.ACCEPTED)
//					.body("CustomerUSer  "+cust.getUserId()+cust.getUserPassword());
//		  
//	}
	@PostMapping("/users/login")
    public ResponseEntity<Object> loginUser( @RequestBody  CustomerUser user) {
		System.out.println(user);
		Customer cu = service.login(user);
		if(cu!=null)
			return ResponseEntity.ok().body(cu);

		 return new ResponseEntity<>("Invalid Credientials ",HttpStatus.NOT_FOUND);
		
   
        
               
    }
	
//	@PostMapping("users/login/{username}{pswd}")
//	public boolean login(
//			@RequestParam String username,
//			@RequestParam String pswd
//			)
//	{
//		System.out.println(username);
//		CustomerUser com=service.findCustomerUserByName(username);
//		if(com.getUserPassword().equals(pswd))
//			return true;
//		return false;
//		
//	}
//	public boolean login(
//			 String username,
//			 String pswd
//			)
//	{
//		CustomerUser com=service.findCustomerUserByName(username);
//		if(com.getUserPassword().equals(pswd))
//			return true;
//		return false;
//		
//	}
 
	 
}
