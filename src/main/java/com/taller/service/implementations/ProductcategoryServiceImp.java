package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Document;
import com.taller.model.Productcategory;
import com.taller.repository.interfaces.DocumentRepository;
import com.taller.repository.interfaces.ProductcategoryRepository;
import com.taller.service.interfaces.ProductcategoryService;

@Service
public class ProductcategoryServiceImp implements ProductcategoryService {

	private ProductcategoryRepository pcr;

	@Autowired
	public ProductcategoryServiceImp(ProductcategoryRepository pcr) {
		this.pcr = pcr;
	}
	
	public Iterable<Productcategory> findAll() {
		return pcr.findAll();
	}
	
	@Override
	public Productcategory save(Productcategory doc) {
		return pcr.save(doc);
	}
	
	@Override
	public Productcategory edit(Productcategory doc) {
		// TODO Auto-generated method stub
		return null;
	}

}
