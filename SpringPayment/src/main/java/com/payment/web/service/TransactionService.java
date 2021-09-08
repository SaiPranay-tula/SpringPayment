package com.payment.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.Customer;
import com.payment.web.beans.Transaction;
import com.payment.web.beans.TransferTypes;
import com.payment.web.custom.TransactionTable;
import com.payment.web.repository.CustomerRepository;
import com.payment.web.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private CustomerService cusserv;
	
	public boolean insertTransaction(Transaction trans) {
		
		if(repo.save(trans) != null) {
			return true;
		}
		
		return false;
	}
//public List<Transaction>getTransactionsByID( String id) {
//		
//		List<Transaction> ttypes = new ArrayList<Transaction>();
//		System.out.println("-----------------kkkkkkkkk-----");
//		
//		repo.findAllByCustomerCustomerid(id).forEach(type -> ttypes.add(type)); 
//		System.out.println("-----------------kkkkkkkkk-----");
//		return ttypes;
//	}
public List<TransactionTable> getTransactionsByID(String id) {
	List<TransactionTable> ttypes = new ArrayList<TransactionTable>();  
	repo.findAllByCustomerCustomerid(id).forEach(type -> ttypes.add(
			new TransactionTable(type.getReceiveraccounholdername(),
					type.getReceiveraccounholdernumber(),
					type.getReceiverbic().getbankname(),
					type.getTransferdate(),
					type.getCurrencyamount())
			));  
	return ttypes;
	

}
}