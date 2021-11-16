package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.Document;
import com.taller.model.Transactionhistory;

public interface TransactionhistoryRepository extends CrudRepository<Transactionhistory, Integer> {

}
