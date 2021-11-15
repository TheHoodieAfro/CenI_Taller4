package com.taller.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.taller.model.Document;

public interface DocumentRespository extends CrudRepository<Document, String> {
}
