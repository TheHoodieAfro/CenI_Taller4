package com.taller.service.interfaces;

import com.taller.model.Product;
import com.taller.model.Productcategory;

public interface ProductcategoryService {
	public Productcategory save(Productcategory prod);
	
	public Productcategory edit(Productcategory prod);
}
