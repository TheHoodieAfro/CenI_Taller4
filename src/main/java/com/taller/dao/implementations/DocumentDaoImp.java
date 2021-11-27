package com.taller.dao.implementations;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.taller.dao.interfaces.DocumentDao;
import com.taller.model.Document;

@Repository
@Transactional
public class DocumentDaoImp implements DocumentDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public void save(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Document> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
