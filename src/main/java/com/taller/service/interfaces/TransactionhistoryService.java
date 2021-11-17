package com.taller.service.interfaces;

import com.taller.model.Transactionhistory;
import com.taller.model.Unitmeasure;

public interface TransactionhistoryService {
	public Transactionhistory save(Transactionhistory prod);
	
	public Transactionhistory edit(Transactionhistory prod);
}
