package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.taller.model.Document;
import com.taller.model.Transactionhistory;
import com.taller.repository.interfaces.DocumentRespository;
import com.taller.repository.interfaces.TransactionhistoryRepository;

public class TransactionhistoryServiceImp {
	
	private TransactionhistoryRepository thr;

	@Autowired
	public TransactionhistoryServiceImp(TransactionhistoryRepository thr) {
		this.thr = thr;
	}
	
	public Transactionhistory save(Transactionhistory doc) {
		return thr.save(doc);
	}
	
	public Iterable<Transactionhistory> findAll() {
		return thr.findAll();
	}

	public Document edit(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
