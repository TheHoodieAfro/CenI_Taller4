package com.taller.dao;

public interface DAO<C> {
	
	void save(C c);
	
	void update(C c);
	
	void delete(C c);
	
	C get(Integer id);
}
