package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Document;
import com.taller.model.Productcategory;
import com.taller.model.Productsubcategory;
import com.taller.repository.interfaces.DocumentRepository;
import com.taller.repository.interfaces.ProductcategoryRepository;
import com.taller.repository.interfaces.ProductsubcategoryRepository;
import com.taller.service.interfaces.ProductcategoryService;
import com.taller.service.interfaces.ProductsubcategoryService;

@Service
public class ProductsubcategoryServiceImp implements ProductsubcategoryService {

	private ProductsubcategoryRepository pscr;
	
	private ProductcategoryRepository pcr;

	@Autowired
	public ProductsubcategoryServiceImp(ProductsubcategoryRepository pscr, ProductcategoryRepository pcr) {
		this.pscr = pscr;
		this.pcr = pcr;
	}
	
	public Iterable<Productsubcategory> findAll() {
		return pscr.findAll();
	}
	
	@Override
	public Productsubcategory save(Productsubcategory doc) {
		doc.setProductcategory(pcr.findById(doc.getProductcategory().getProductcategoryid()).get());
		return pscr.save(doc);
	}
	
	@Override
	public Productsubcategory edit(Productsubcategory doc) {
		// TODO Auto-generated method stub
		return null;
	}

}
