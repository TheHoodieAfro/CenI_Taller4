package com.taller.service.interfaces;

import com.taller.model.Product;
import com.taller.model.Vendor;

public interface ProductVendorService {
	public Vendor save(Vendor vendor);
	
	public Vendor edit(Vendor vendor);
}
