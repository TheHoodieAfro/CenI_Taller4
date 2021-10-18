package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.prod.Product;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.service.interfaces.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductRepository pr;

	@Autowired
	public ProductServiceImp(ProductRepository pr) {
		this.pr = pr;
	}
	
	@Override
	public Product save(Product prod) {
		return pr.save(prod);
	}

	@Override
	public Product edit(Product prod) {
		// TODO Auto-generated method stub
		return null;
	}

}
