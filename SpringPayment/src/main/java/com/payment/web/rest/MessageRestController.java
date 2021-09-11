package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.service.MessageService;

@RestController
@CrossOrigin()
public class MessageRestController {
	
	@Autowired
	private MessageService service;
	
	@GetMapping("/messages")
	public ResponseEntity<Object> getAllMessages(){
		if(service.getMessages()!=null) {
			return ResponseEntity.ok().body(service.getMessages());			
		}
		return new ResponseEntity<>("Messages not found",HttpStatus.NOT_FOUND);
		
		
	}

}
