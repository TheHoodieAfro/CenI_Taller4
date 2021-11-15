package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.Productvendor;
import com.taller.model.ProductvendorPK;

public interface ProductvendorRespository extends CrudRepository<Productvendor, ProductvendorPK> {

}
