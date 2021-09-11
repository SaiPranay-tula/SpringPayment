package com.payment.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.web.service.TransferTypesService;

@RestController
@CrossOrigin()
public class TransferRestController {
	

	@Autowired
	private TransferTypesService service;
	

	@GetMapping("/transfertypes")
	public ResponseEntity<Object> transferTypes() {

		if(service.getTransferTypes()!=null)
		return ResponseEntity.ok().body(service.getTransferTypes());
		return new ResponseEntity<>("NO Transfer tyes Found",HttpStatus.NOT_FOUND);

	}
	

}
