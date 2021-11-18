package com.taller.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Product;
import com.taller.model.Productsubcategory;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.repository.interfaces.ProductsubcategoryRepository;
import com.taller.repository.interfaces.UnitmeasureRepository;
import com.taller.service.interfaces.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductRepository pr;
	
	private UnitmeasureRepository umr;
	
	private ProductsubcategoryRepository pscr;
	
	@Autowired
	public ProductServiceImp(ProductRepository pr, UnitmeasureRepository umr, ProductsubcategoryRepository pscr) {
		this.pr = pr;
		this.umr = umr;
		this.pscr = pscr;
	}
	
	public Iterable<Product> findAll() {
		return pr.findAll();
	}
	
	public Optional<Product> findById(Integer id) {
		return pr.findById(id);
	}
	
	@Override
	public Product save(Product prod) {
		prod.setProductsubcategory(pscr.findById(prod.getProductsubcategory().getProductsubcategoryid()).get());
		prod.setUnitmeasure1(umr.findById(prod.getUnitmeasure1().getUnitmeasurecode()).get());
		prod.setUnitmeasure2(umr.findById(prod.getUnitmeasure2().getUnitmeasurecode()).get());
		return pr.save(prod);
	}

	@Override
	public Product edit(Product prod) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(Product prod) {
		pr.deleteById(prod.getProductid());
	}

}
