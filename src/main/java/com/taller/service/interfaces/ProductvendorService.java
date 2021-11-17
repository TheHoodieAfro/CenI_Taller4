package com.taller.service.interfaces;

import com.taller.model.Product;
import com.taller.model.Productvendor;
import com.taller.model.Vendor;

public interface ProductvendorService {
	public Productvendor save(Productvendor vendor);
	
	public Productvendor edit(Productvendor vendor);
}
