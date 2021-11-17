package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Document;
import com.taller.model.Transactionhistory;
import com.taller.repository.interfaces.DocumentRepository;
import com.taller.repository.interfaces.TransactionhistoryRepository;
import com.taller.service.interfaces.TransactionhistoryService;

@Service
public class TransactionhistoryServiceImp implements TransactionhistoryService {
	
	private TransactionhistoryRepository thr;

	@Autowired
	public TransactionhistoryServiceImp(TransactionhistoryRepository thr) {
		this.thr = thr;
	}
	
	public Iterable<Transactionhistory> findAll() {
		return thr.findAll();
	}
	
	@Override
	public Transactionhistory save(Transactionhistory doc) {
		return thr.save(doc);
	}

	@Override
	public Transactionhistory edit(Transactionhistory doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
