package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dao.implementations.VendorDaoImp;
import com.taller.model.Vendor;
import com.taller.service.interfaces.VendorService;

@Service
public class VendorServiceImp implements VendorService{

	private VendorDaoImp vr;

	@Autowired
	public VendorServiceImp(VendorDaoImp vr) {
		this.vr = vr;
	}
	
	public Iterable<Vendor> findAll() {
		return vr.findAll();
	}
	
	@Override
	public void save(Vendor vendor) {
		vr.save(vendor);
	}

	@Override
	public void edit(Vendor vendor) {
		vr.update(vendor);
	}

}
