package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Product;
import com.taller.model.Productvendor;
import com.taller.model.Vendor;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.repository.interfaces.ProductvendorRepository;
import com.taller.repository.interfaces.VendorRepository;
import com.taller.service.interfaces.ProductService;
import com.taller.service.interfaces.ProductvendorService;
import com.taller.service.interfaces.VendorService;

@Service
public class ProductvendorServiceImp implements ProductvendorService{

	private ProductvendorRepository pvr;

	@Autowired
	public ProductvendorServiceImp(ProductvendorRepository pvr) {
		this.pvr = pvr;
	}
	
	public Iterable<Productvendor> findAll() {
		return pvr.findAll();
	}
	
	@Override
	public Productvendor save(Productvendor vendor) {
		// TODO Auto-generated method stub
		return pvr.save(vendor);
	}

	@Override
	public Productvendor edit(Productvendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

}
