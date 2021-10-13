package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.prchasing.Productvendor;
import com.taller.model.prchasing.ProductvendorPK;

public interface ProductvendorRespository extends CrudRepository<Productvendor, ProductvendorPK> {

}
