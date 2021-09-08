package com.payment.web.custom;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import com.payment.web.beans.Customer;
import com.payment.web.beans.Transaction;
import com.payment.web.service.BankService;
import com.payment.web.service.CurrencyService;
import com.payment.web.service.CustomerService;
import com.payment.web.service.MessageService;
import com.payment.web.service.TransactionService;
import com.payment.web.service.TransferTypesService;

public class Test {
	@Autowired
	CustomerService sc;
	@Autowired
	CurrencyService cc;
	@Autowired
	TransactionService tc ;
	@Autowired
	BankService bc;
	@Autowired
	TransferTypesService tts;
	@Autowired
	MessageService ms;
	public boolean insertTransaction(TransactTab tras ) {
		
		
		System.out.println("transaction"+tras);
		Date date=new java.util.Date();
		 
		
		Transaction trans = new Transaction();
		trans.setCustomerid(sc.findCustomer(tras.getCustomerid()));
		trans.setCurrencycode(cc.findById("INR"));
		trans.setSenderbic(bc.findBankByBIC("ACBLINBBXXX"));
		trans.setReceiverbic(bc.findBankByBIC(tras.getReceiverBic()));
		trans.setReceiveraccounholdername(tras.getRaccountname());
		trans.setReceiveraccounholdernumber(tras.getRaccountnumber());
		trans.setTransfertypecode(tts.findBytype(tras.getTransfertype()));
		trans.setMessagecode(ms.findmessage(tras.getMessagecode()));
		trans.setCurrencyamount(tras.getInramount());
		trans.setInramount(tras.getInramount());
		trans.setTransferfees(tras.getTransferfee());
		trans.setDate(date);
		
		
		if(sc.updateAmount(trans.getCustomerid(), trans.getInramount())  &&
				tc.insertTransaction(trans))
	     return true;
		
		return false;
		
	}

}
