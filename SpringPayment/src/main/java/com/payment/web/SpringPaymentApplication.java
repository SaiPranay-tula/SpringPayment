package com.payment.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;


import com.payment.web.beans.Customer;
import com.payment.web.beans.Logger;
import com.payment.web.beans.Transaction;
import com.payment.web.beans.TransferTypes;

import com.payment.web.custom.TransactTab;
import com.payment.web.repository.TransferTypesRepository;
import com.payment.web.service.BankService;
import com.payment.web.service.CurrencyService;
import com.payment.web.service.CustomerService;
import com.payment.web.service.CustomerUserService;
import com.payment.web.service.MessageService;
import com.payment.web.service.TransactionService;
import com.payment.web.service.TransferTypesService;



@SpringBootApplication
public class SpringPaymentApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(SpringPaymentApplication.class, args);
		System.out.println("HELLo");
		
		
//		
//		CustomerUserService service = context.getBean(CustomerUserService.class);
//		System.out.println("Service-");
//		System.out.println(service.findCustomerUserByName("Shalini Mittal"));
//		
//		CustomerService cu = context.getBean(CustomerService.class);
//		System.out.println(cu.findCustomerById("69652133523248"));
//		
//		BankService bs =context.getBean(BankService.class);
//		System.out.println(bs.findBankByBIC("ABBLINBBXXX"));
//		
//		TransferTypesService ts = context.getBean(TransferTypesService.class);
//		System.out.println(ts.getTransferTypes());
//		
//		TransactionService tts = context.getBean(TransactionService.class);
//		System.out.println(tts.getTransactionsByID("71319440983198"));
//		
//		TransactTab tras = new TransactTab("71319440983198","ABNAINBBAHM",
//									"Pranay","324234234324","C",
//									"CHQB",234343.34,120.2);
//		System.out.println(tras);
//		
//		CustomerService cservice= context.getBean(CustomerService.class);
//		System.out.println(cservice.findCustomer("69652133523248"));
//		
		//System.out.println(new Test().insertTransaction(tras));
		//System.out.println(cservice.findCustomerById(tras.getCustomerid()));
		
		
		
		
	}

}
