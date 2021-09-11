package com.payment.web.rest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;
import com.payment.web.beans.Customer;
import com.payment.web.custom.CustomerTable;
import com.payment.web.custom.SDNList;
import com.payment.web.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService cus_service;
	
	@GetMapping("/{cid}")
	public ResponseEntity<Object> findCustomer(@PathVariable String cid) {
		Customer c = cus_service.findCustomer(cid);
		if (c!=null)
			return ResponseEntity.ok().body(new CustomerTable(c.getcustomerid(), c.getaccountholdername(),
					c.getclearbalance(), c.getoverdraftflag()));

		else {
			return new ResponseEntity<>("Customer not found",HttpStatus.NOT_FOUND);
				}
	}

	@GetMapping("/name/{name}")	
	public ResponseEntity<Object> checkList(@PathVariable String name) {
		System.out.println(name);
		try {
			if(SDNList.Search(name)) {
				//return ResponseEntity.ok().body(true);
				return ResponseEntity.status(HttpStatus.OK).body(true);
				
			}
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Customer_Name not found",HttpStatus.NOT_FOUND);
	}

}
