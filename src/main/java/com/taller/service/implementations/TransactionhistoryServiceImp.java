package com.taller.service.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dao.implementations.ProductDaoImp;
import com.taller.dao.implementations.TransactionhistoryDaoImp;
import com.taller.model.Product;
import com.taller.model.Transactionhistory;
import com.taller.service.interfaces.TransactionhistoryService;

@Service
public class TransactionhistoryServiceImp implements TransactionhistoryService {
	
	private TransactionhistoryDaoImp thr;
	
	private ProductDaoImp pr;

	@Autowired
	public TransactionhistoryServiceImp(TransactionhistoryDaoImp thr, ProductDaoImp pr) {
		this.thr = thr;
		this.pr = pr;
	}
	
	public Iterable<Transactionhistory> findAll() {
		return thr.findAll();
	}
	
	@Override
	public void save(Transactionhistory doc) {
		Product p = pr.findById(doc.getProduct().getProductid());
		
		doc.setProduct(p);
		p.addTransactionhistory(doc);
		
		pr.save(p);
		thr.save(doc);
	}

	@Override
	public void edit(Transactionhistory doc) {
		thr.update(doc);
	}

	public Transactionhistory findById(Integer id) {
		return thr.findById(id);
	}

	public void delete(Transactionhistory transactionhistory) {
		thr.delete(transactionhistory.getTransactionid());
	}

	public void update(Transactionhistory transactionhistory) {
		Transactionhistory mth = thr.findById(transactionhistory.getTransactionid());
		
		mth.setActualcost(transactionhistory.getActualcost());
		mth.setQuantity(transactionhistory.getQuantity());
		mth.setTransactiondate(transactionhistory.getTransactiondate());
		mth.setModifieddate(transactionhistory.getModifieddate());
		mth.setProduct(pr.findById(transactionhistory.getProduct().getProductid()));
		
		thr.update(mth);
	}

	public Iterable<Transactionhistory> findByProducts(Integer productId) {
		Iterable<Transactionhistory> all = thr.findAll();
			
		List<Transactionhistory> cond = new ArrayList<Transactionhistory>();
		for(Transactionhistory th : all) {
			if(th.getProduct().getProductid() == productId) {
				cond.add(th);
			}
		}
		
		Iterable<Transactionhistory> xd = cond;
		return xd;
	}
	
	public Iterable<Transactionhistory> findByProducts2(Integer productId) {
		Product p = pr.findById(productId);
		List<Transactionhistory> cond = p.getTransactionhistories();
		
		Iterable<Transactionhistory> xd = cond;
		return xd;
	}
	
}
