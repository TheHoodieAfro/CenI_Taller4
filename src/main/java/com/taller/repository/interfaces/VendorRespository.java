package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.Productvendor;
import com.taller.model.ProductvendorPK;
import com.taller.model.Vendor;

public interface VendorRespository extends CrudRepository<Vendor, Integer> {

}
