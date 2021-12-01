package com.taller.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dao.implementations.DocumentDaoImp;
import com.taller.dao.implementations.ProductDaoImp;
import com.taller.dao.implementations.TransactionhistoryDaoImp;
import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.model.Productdocument;
import com.taller.model.Transactionhistory;
import com.taller.repository.interfaces.ProductdocumentRepository;
import com.taller.repository.interfaces.ProductsubcategoryRepository;
import com.taller.repository.interfaces.UnitmeasureRepository;
import com.taller.service.interfaces.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	private ProductDaoImp pr;
	
	private TransactionhistoryDaoImp thr;
	
	private DocumentDaoImp dr;
	
	private UnitmeasureRepository umr;
	
	private ProductsubcategoryRepository pscr;
	
	private ProductdocumentRepository pdr;
	
	@Autowired
	public ProductServiceImp(ProductdocumentRepository pdr, DocumentDaoImp dr, TransactionhistoryDaoImp thr, ProductDaoImp pr, UnitmeasureRepository umr, ProductsubcategoryRepository pscr) {
		this.pr = pr;
		this.umr = umr;
		this.pscr = pscr;
		this.thr = thr;
		this.dr = dr;
		this.pdr = pdr;
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
		List<Transactionhistory> ths = prod.getTransactionhistories();
		if(!ths.isEmpty()) {
			for(Transactionhistory th : ths) {
				thr.delete(th.getTransactionid());
			}
		}
		
		List<Productdocument> pds = prod.getProductdocuments();
		if(!pds.isEmpty()) {
			for(Productdocument pd : pds) {
				Document d = dr.findById(pd.getDocument().getDocumentnode());
				d.removeProductdocument(pd);
				dr.save(d);
				
				pdr.deleteById(pd.getId());
			}
		}
		
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
