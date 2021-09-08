package com.payment.web.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;
import com.payment.web.beans.Currency;
import com.payment.web.beans.Transaction;
import com.payment.web.beans.TransferTypes;
import com.payment.web.custom.SDNList;
import com.payment.web.custom.TransactTab;
import com.payment.web.custom.TransactionTable;
import com.payment.web.repository.TransactionRepository;
import com.payment.web.service.BankService;
import com.payment.web.service.CurrencyService;
import com.payment.web.service.CustomerService;
import com.payment.web.service.MessageService;
import com.payment.web.service.TransactionService;
import com.payment.web.service.TransferTypesService;

@RestController("/transaction")
@CrossOrigin()
public class TransactionRestController {
	
	@Autowired
	private TransferTypesService service;
	
	@Autowired
	private TransactionService tservice; 
	
	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private CustomerService sc;
	
	@Autowired
	private CurrencyService csi;
	@Autowired
	private TransactionService tc ;
	@Autowired
	private 	BankService bc;
	@Autowired
	private TransferTypesService tts;
	@Autowired
	private MessageService ms;
	
	@GetMapping("/transfertypes")
	public List<TransferTypes> transferTypes() {
		
		return  service.getTransferTypes();
		
	}
	
	@PostMapping("/success/insert")
	public boolean insertTransaction(@RequestBody TransactTab tras ) {
		System.out.println("transaction"+tras);
		Date date=new java.util.Date();
		
		Transaction trans = new Transaction();
		trans.setCustomerid(sc.findCustomer(tras.getCustomerid()));
		trans.setCurrencycode(csi.findById("INR"));
		trans.setSenderbic(bc.findBankByBIC("ACBLINBBXXX"));
		trans.setReceiverbic(bc.findBankByBIC(tras.getReceiverBic()));
		trans.setReceiveraccounholdername(tras.getRaccountname());
		trans.setReceiveraccounholdernumber(tras.getRaccountnumber());
		//trans.setTransfertypecode(tts.findBytype(tras.getTransfertype()));
		trans.setMessagecode(ms.findmessage(tras.getMessagecode()));
		trans.setCurrencyamount(tras.getInramount());
		trans.setInramount(tras.getInramount());
		trans.setTransferfees(tras.getTransferfee());
		trans.setDate(date);
		
		
		if(cservice.updateAmount(trans.getCustomerid(), trans.getInramount())  &&
				tservice.insertTransaction(trans))
	     return true;
		
		return false;
		
	}
	
	@GetMapping("/transaction/{custid}")
	public List<TransactionTable> getTrans(@PathVariable String custid)
	{
		System.out.println("//////"+custid);
		System.out.println(tservice.getTransactionsByID(custid));
		return tservice.getTransactionsByID(custid);
	
		
	}
	@GetMapping("/transaction/receiver/{receivername}")
	public boolean isValid(@PathVariable String receivername) throws CsvValidationException, FileNotFoundException, IOException
	{
	
		return SDNList.Search(receivername);

		
	}
	
	

}
