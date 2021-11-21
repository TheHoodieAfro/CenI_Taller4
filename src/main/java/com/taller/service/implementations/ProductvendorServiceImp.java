package com.taller.service.implementations;

import java.util.Optional;

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
	
	private VendorRepository vr;
	
	private ProductRepository pr;

	@Autowired
	public ProductvendorServiceImp(ProductvendorRepository pvr, VendorRepository vr, ProductRepository pr) {
		this.pvr = pvr;
		this.vr = vr;
		this.pr = pr;
	}
	
	public Iterable<Productvendor> findAll() {
		return pvr.findAll();
	}
	
	@Override
	public Productvendor save(Productvendor vendor) {
		vendor.setVendor(vr.findById(vendor.getVendor().getBusinessentityid()).get());
		vendor.setProduct(pr.findById(vendor.getProduct().getProductid()).get());
		return pvr.save(vendor);
	}

	@Override
	public Productvendor edit(Productvendor vendor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Productvendor> findById(Integer id) {
		// TODO Auto-generated method stub
		return pvr.findById(id);
	}

	public void delete(Productvendor productvendor) {
		// TODO Auto-generated method stub
		pvr.deleteById(productvendor.getId());
	}

	public void update(Productvendor pv) {
		Productvendor mpv = pvr.findById(pv.getId()).get();
		
		mpv.setMaxorderqty(pv.getMaxorderqty());
		mpv.setMinorderqty(pv.getMinorderqty());
		mpv.setStandardprice(pv.getStandardprice());
		mpv.setVendor(vr.findById(pv.getVendor().getBusinessentityid()).get());
		mpv.setProduct(pr.findById(pv.getProduct().getProductid()).get());
		
		pvr.save(mpv);
	}

}
