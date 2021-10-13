package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.prod.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
