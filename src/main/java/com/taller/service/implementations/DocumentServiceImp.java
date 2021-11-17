package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.repository.interfaces.DocumentRepository;
import com.taller.repository.interfaces.ProductRepository;

@Service
public class DocumentServiceImp {
	
	private DocumentRepository dr;

	@Autowired
	public DocumentServiceImp(DocumentRepository dr) {
		this.dr = dr;
	}
	
	public Document save(Document doc) {
		return dr.save(doc);
	}
	
	public Iterable<Document> findAll() {
		return dr.findAll();
	}

	public Document edit(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
