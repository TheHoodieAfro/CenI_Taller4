package com.taller.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class OperatorController {
	
	public OperatorController() {
		
	}
	
	@GetMapping("/transactions")
    public String transactions() {
        return "transactions.html";
    }
	
	@GetMapping("/documents")
    public String documents() {
        return "documents.html";
    }
	
}
