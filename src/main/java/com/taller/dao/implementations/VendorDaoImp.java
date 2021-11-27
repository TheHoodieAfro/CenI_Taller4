package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.taller.dao.interfaces.VendorDao;
import com.taller.model.Vendor;

@Repository
@Transactional
public class VendorDaoImp implements VendorDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void save(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vendor vendor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
