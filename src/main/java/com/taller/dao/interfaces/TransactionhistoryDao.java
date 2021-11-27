package com.taller.dao.interfaces;

import java.util.List;

import com.taller.model.Product;
import com.taller.model.Transactionhistory;

public interface TransactionhistoryDao {
	
	void save(Transactionhistory transactionhistory);
	
	void update(Transactionhistory transactionhistory);
	
	void delete(Transactionhistory transactionhistory);
	
	List<Transactionhistory> findAll();
	
	Transactionhistory findById(Integer id);
	
	//List<Transactionhistory> findAllByOrderReference();
	
	List<Transactionhistory> findAllByProduct(Product product);
	
}
