package com.taller.dao.interfaces;

import java.util.List;

import com.taller.model.Vendor;

public interface VendorDao {
	
	void save(Vendor vendor);
	
	void update(Vendor vendor);
	
	void delete(Vendor vendor);
	
	List<Vendor> findAll();
	
	Vendor findById(Integer id);
	
}
