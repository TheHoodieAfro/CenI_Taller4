package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.taller.dao.interfaces.TransactionhistoryDao;
import com.taller.model.Product;
import com.taller.model.Transactionhistory;

@Repository
@Transactional
public class TransactionhistoryDaoImp implements TransactionhistoryDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void save(Transactionhistory transactionhistory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Transactionhistory transactionhistory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transactionhistory transactionhistory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transactionhistory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactionhistory findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactionhistory> findAllByProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
