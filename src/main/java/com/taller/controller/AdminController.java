package com.taller.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController {
	
	public AdminController() {
		
	}
	
	@GetMapping("/index")
    public String dashboard() {
        return "index.html";
    }
	
}
