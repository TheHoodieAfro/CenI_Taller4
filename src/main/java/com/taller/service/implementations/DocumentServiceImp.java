package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.repository.interfaces.DocumentRespository;
import com.taller.repository.interfaces.ProductRepository;

@Service
public class DocumentServiceImp {
	
	private DocumentRespository dr;

	@Autowired
	public DocumentServiceImp(DocumentRespository dr) {
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
