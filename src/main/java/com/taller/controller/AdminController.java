package com.taller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller.model.Product;
import com.taller.service.implementations.ProductServiceImp;

@Controller
public class AdminController {
	
	ProductServiceImp ps;
	
	public AdminController(ProductServiceImp ps) {
		this.ps = ps;
	}
	
	@GetMapping("/products")
    public String products(Model model) {
		model.addAttribute("products", ps.findAll());
        return "admin/products";
    }
	
	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "admin/addProduct";
	}
	
	@PostMapping("/addProduct")
	public String saveProduct(Product product, Model model, @RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel"))
			ps.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/vendors")
    public String vendors() {
        return "admin/vendors";
    }
	
}
