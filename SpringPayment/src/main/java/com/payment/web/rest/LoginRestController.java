package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.beans.Customer;
import com.payment.web.custom.AuthRequest;
import com.payment.web.service.CustomerUserService;
import com.payment.web.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRestController {

	@Autowired
	private CustomerUserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder bencoder;

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
//	@PostMapping("/users/login")
//	public ResponseEntity<Object> loginUser(@RequestBody CustomerUser user) {
//		System.out.println(user);
//		Customer cu = service.login(user);
//		if (cu != null)
//			return ResponseEntity.ok().body(cu);
//
//		return new ResponseEntity<>("Invalid Credientials ", HttpStatus.NOT_FOUND);
//
//	}

	@GetMapping("/user/{user}")
	public ResponseEntity<Object> loginUser(@PathVariable String user) {
		System.out.println(user);
		Customer cu = service.login(user);
		if (cu != null)
			return ResponseEntity.ok().body(cu);

		return new ResponseEntity<>("Invalid Credientials ", HttpStatus.NOT_FOUND);

	}

	@PostMapping("/authenticate")
	public ResponseEntity<Object> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		System.out.println(authRequest);
		try {
			// System.out.println(bencoder.encode(authRequest.getUserPassword())+"auth
			// "+authRequest.getUserPassword());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getUserPassword()));
		} catch (Exception ex) {
//			throw new Exception("inavalid username/password");
			return new ResponseEntity<>("Invalid Credientials ", HttpStatus.NOT_FOUND);
		}
		// System.out.println(("valid"));
		return ResponseEntity.ok().body(jwtUtil.generateToken(authRequest.getUsername()));
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
//	public String encodePassword(String password) {
//		System.out.println(encoder.encode(password) +"  method   "+password);
//		
//		return encoder.encode(password);
//	}

}
