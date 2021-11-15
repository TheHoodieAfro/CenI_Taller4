package com.taller.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
	
	public AdminController() {
		
	}
	
	@GetMapping("/products")
    public String products() {
        return "products.html";
    }
	
	@GetMapping("/vendors")
    public String vendors() {
        return "vendors.html";
    }
	
}
