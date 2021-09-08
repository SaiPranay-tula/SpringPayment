package com.payment.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Message;

import com.payment.web.repository.MessageRepository;
@Service
public class MessageService {
	
	@Autowired
	private MessageRepository repo;
	
	public List<Message> getMessages()
	{
		
			List<Message> ttypes = new ArrayList<Message>();  
			repo.findAll().forEach(type -> ttypes.add(type));  
			return ttypes;
			
		
	}
	public Message findmessage(String mess) {
		
		return this.repo.findById(mess).get();
	}
	
	

}
