package com.taller.unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller.boot.Taller1Application;
import com.taller.model.prod.Product;
import com.taller.repository.interfaces.ProductRepository;
import com.taller.service.implementations.ProductServiceImp;
import com.taller.service.interfaces.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
class ProductServiceTest {
	
	@Mock
	private ProductRepository pr;
	
	@InjectMocks
	private ProductService ps;
	
	@Autowired
	public ProductServiceTest() {
		this.ps = new ProductServiceImp(pr);
	}

	@Nested
	@DisplayName("Save products")
	class save {
		
		@Test
		public void save() {
			Product p = new Product();
			
			when(pr.save(p)).thenReturn(p);
			
			assertEquals(ps.save(p).getProductid(), p.getProductid());
		}
		
	}
	
	@Nested
	@DisplayName("Edit products")
	class edit {
		
		@Test
		public void edit() {
		}
		
	}

}
