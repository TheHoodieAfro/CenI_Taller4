package com.taller.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.taller.model.Product;

public interface ProductDao {
	
	void save(Product product);
	
	void update(Product product);
	
	void delete(Product product);
	
	List<Product> findAll();
	
	Product findById(Integer id);
	
	List<Product> findAllByStartDate(LocalDate date);
	
	List<Product> findAllByEndDate(LocalDate date);
	
	List<Product> findAllByTransactionhistoryBetweenDatesOrderedByProductName(LocalDate date1, LocalDate date2);
	
	List<Product> findAllByAtLeastTwoDocuments();
	
}
