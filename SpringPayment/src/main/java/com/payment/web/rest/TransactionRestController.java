package com.payment.web.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;
import com.payment.web.beans.Transaction;
import com.payment.web.custom.SDNList;
import com.payment.web.custom.TransactTab;
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
	private TransactionService tservice;

	@Autowired
	private CustomerService cservice;

	@Autowired
	private CustomerService sc;

	@Autowired
	private CurrencyService csi;

	@Autowired
	private BankService bc;

	@Autowired
	private MessageService ms;

	@Autowired
	private TransferTypesService tts;

	@PostMapping("/success/insert")
	public ResponseEntity<Object> insertTransaction(@RequestBody TransactTab tras) {
		System.out.println("transaction" + tras);
		Transaction trans = new Transaction();
		Date date = new java.util.Date();
		try {
			System.out.println(tras);

			trans.setCustomerid(sc.findCustomer(tras.getCustomerid()));
			trans.setCurrencycode(csi.findById("INR"));
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

		} catch (Exception E) {
			System.out.println(E);
			return new ResponseEntity<>("Transaction Falied", HttpStatus.FORBIDDEN);

		}

		if (cservice.updateAmount(trans.getCustomerid(), trans.getInramount()) && tservice.insertTransaction(trans))
			return new ResponseEntity<>("Transaction SuccessFull", HttpStatus.CREATED);

		return new ResponseEntity<>("Transaction Falied", HttpStatus.FORBIDDEN);

	}

	@GetMapping("/transaction/{custid}")
	public ResponseEntity<Object> getTrans(@PathVariable String custid) {

		if (tservice.getTransactionsByID(custid) != null)
			return ResponseEntity.ok().body(tservice.getTransactionsByID(custid));

		return new ResponseEntity<>("No Transactions Found", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/transaction/receiver/{receivername}")
	public ResponseEntity<Object> isValid(@PathVariable String receivername)
			throws CsvValidationException, FileNotFoundException, IOException {
		if (SDNList.Search(receivername)) {
			return ResponseEntity.ok().body(true);
		}

		return ResponseEntity.ok().body(false);

	}

}
