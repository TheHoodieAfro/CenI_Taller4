package com.taller.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.model.Product;
import com.taller.model.Unitmeasure;
import com.taller.model.Vendor;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.repository.interfaces.UnitmeasureRepository;
import com.taller.repository.interfaces.VendorRepository;
import com.taller.service.interfaces.ProductService;
import com.taller.service.interfaces.ProductvendorService;
import com.taller.service.interfaces.UnitmeasureService;
import com.taller.service.interfaces.VendorService;

@Service
public class UnitmeasureServiceImp implements UnitmeasureService {

	private UnitmeasureRepository umr;

	@Autowired
	public UnitmeasureServiceImp(UnitmeasureRepository umr) {
		this.umr = umr;
	}
	
	public Iterable<Unitmeasure> findAll() {
		return umr.findAll();
	}
	
	@Override
	public Unitmeasure save(Unitmeasure vendor) {
		// TODO Auto-generated method stub
		return umr.save(vendor);
	}

	@Override
	public Unitmeasure edit(Unitmeasure vendor) {
		// TODO Auto-generated method stub
		return null;
	}

}
