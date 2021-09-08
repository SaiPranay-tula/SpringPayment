package com.payment.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.beans.TransferTypes;
import com.payment.web.repository.TransferTypesRepository;

@Service
public class TransferTypesService {

	public TransferTypesService() {
		
	}
	
//	List<Books> books = new ArrayList<Books>();  
//	booksRepository.findAll().forEach(books1 -> books.add(books1));  
//	return books;
	
	
	@Autowired
	private TransferTypesRepository repo;
	public List<TransferTypes> getTransferTypes() {
		List<TransferTypes> ttypes = new ArrayList<TransferTypes>();  
		repo.findAll().forEach(type -> ttypes.add(type));  
		return ttypes;
	}
//	public TransferTypes findBytype(String tr) {
//		return this.repo.findById(tr.charAt(0)).get();
//	}
	
	
	
}
