package com.payment.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.payment.web.beans.Customer;
import com.payment.web.beans.Transaction;


public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
	public List<Transaction> findAllByCustomerCustomerid(String customerid);
}
