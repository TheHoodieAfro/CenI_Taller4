package com.taller.service.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.dao.implementations.DocumentDaoImp;
import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.model.Productdocument;
import com.taller.repository.interfaces.DocumentRepository;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.service.interfaces.DocumentService;

@Service
public class DocumentServiceImp implements DocumentService {
	
	private DocumentDaoImp dr;

	@Autowired
	public DocumentServiceImp(DocumentDaoImp dr) {
		this.dr = dr;
	}
	
	public Iterable<Document> findAll() {
		return dr.findAll();
	}
	
	@Override
	public void save(Document doc) {
		dr.save(doc);
	}
	
	@Override
	public void edit(Document doc) {
		dr.update(doc);
	}

	public Document findById(Integer id) {
		// TODO Auto-generated method stub
		return dr.findById(id);
	}

	public void delete(Document document) {
		dr.delete(document.getDocumentnode());
	}

	public void update(Document dd) {
		Document d = dr.findById(dd.getDocumentnode());
		
		d.setFileextension(dd.getFileextension());
		d.setFilename(dd.getFilename());
		d.setModifieddate(LocalDate.now());
		d.setTitle(dd.getTitle());
		
		dr.update(d);
	}

	public Iterable<Product> findProductsByDocument(Integer id) {
		List<Productdocument> pds = dr.findById(id).getProductdocuments();
		
		List<Product> ps = new ArrayList<Product>();
		for(Productdocument pd : pds) {
			ps.add(pd.getProduct());
		}
		
		Iterable<Product> ret = ps;
		return ret;
	}
	
}
