package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.Product;
import com.taller.model.Productdocument;

public interface ProductdocumentRepository extends CrudRepository<Productdocument, Integer> {

}
