package com.payment.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.web.beans.TransferTypes;
import com.payment.web.repository.TransferTypesRepository;

@Service
public class TransferTypesService {

	public TransferTypesService() {

	}

	@Autowired
	private TransferTypesRepository repo;

	public List<TransferTypes> getTransferTypes() {
		List<TransferTypes> ttypes = new ArrayList<TransferTypes>();
		repo.findAll().forEach(type -> ttypes.add(type));
		return ttypes;
	}

	public TransferTypes findBytype(String tr) {
		return this.repo.findById(tr.charAt(0)).get();
	}

}
