package com.taller.dao.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.taller.model.Document;

public interface DocumentDao {
	
	void save(Document document);
	
	void update(Document document);
	
	void delete(Document document);
	
	List<Document> findAll();
	
	Document findById(Integer id);
	
}
