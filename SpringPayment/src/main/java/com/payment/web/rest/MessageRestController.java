package com.payment.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.beans.Message;
import com.payment.web.service.MessageService;

@RestController
@CrossOrigin()
public class MessageRestController {
	
	@Autowired
	private MessageService service;
	
	@GetMapping("/messages")
	public List<Message> getAllMessages(){
		return service.getMessages();
		
	}

}
