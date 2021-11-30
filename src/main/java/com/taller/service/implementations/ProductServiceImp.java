package com.taller.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dao.implementations.ProductDaoImp;
import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.model.Productdocument;
import com.taller.repository.interfaces.ProductsubcategoryRepository;
import com.taller.repository.interfaces.UnitmeasureRepository;
import com.taller.service.interfaces.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductDaoImp pr;
	
	private UnitmeasureRepository umr;
	
	private ProductsubcategoryRepository pscr;
	
	@Autowired
	public ProductServiceImp(ProductDaoImp pr, UnitmeasureRepository umr, ProductsubcategoryRepository pscr) {
		this.pr = pr;
		this.umr = umr;
		this.pscr = pscr;
	}
	
	public Iterable<Product> findAll() {
		return pr.findAll();
	}
	
	public Product findById(Integer id) {
		return pr.findById(id);
	}
	/*
	public Iterable<Product> findAllById(Integer id) {
		ArrayList<Product> p = (ArrayList<Product>) pr.findAll();
		Integer pv = pvr.findById(id).get().getId();
		ArrayList<Product> toReturn = new ArrayList<Product>();
		
		for (Product pp : p) {
			if(pp.getBusinessentity().getName().equals(name)) {
				toReturn.add(pp);
			}
		}
		return toReturn;
	}*/
	
	@Override
	public void save(Product prod) {
		prod.setProductsubcategory(pscr.findById(prod.getProductsubcategory().getProductsubcategoryid()).get());
		prod.setUnitmeasure1(umr.findById(prod.getUnitmeasure1().getUnitmeasurecode()).get());
		prod.setUnitmeasure2(umr.findById(prod.getUnitmeasure2().getUnitmeasurecode()).get());
		pr.save(prod);
	}

	@Override
	public void edit(Product prod) {
		pr.update(prod);
	}
	
	public void delete(Product prod) {
		pr.delete(prod.getProductid());
	}

	public void update(Product p) {
		Product mp = pr.findById(p.getProductid());
		
		mp.setDaystomanufacture(p.getDaystomanufacture());
		mp.setName(p.getName());
		mp.setProductnumber(p.getProductnumber());
		mp.setProductsubcategory(pscr.findById(p.getProductsubcategory().getProductsubcategoryid()).get());
		mp.setUnitmeasure1(umr.findById(p.getUnitmeasure1().getUnitmeasurecode()).get());
		mp.setUnitmeasure2(umr.findById(p.getUnitmeasure2().getUnitmeasurecode()).get());
		
		pr.update(mp);
	}

	public Iterable<Document> findDocumentsByProduct(Integer id) {
		List<Productdocument> pds = pr.findById(id).getProductdocuments();
		
		List<Document> ds = new ArrayList<Document>();
		for(Productdocument pd : pds) {
			ds.add(pd.getDocument());
		}
		
		Iterable<Document> ret = ds;
		return ret;
	}

}
