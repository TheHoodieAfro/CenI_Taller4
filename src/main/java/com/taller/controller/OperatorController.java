package com.taller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.model.Transactionhistory;
import com.taller.model.Vendor;
import com.taller.service.implementations.DocumentServiceImp;
import com.taller.service.implementations.ProductServiceImp;
import com.taller.service.implementations.TransactionhistoryServiceImp;
import com.taller.service.implementations.VendorServiceImp;

@Controller
public class OperatorController {
	
	DocumentServiceImp ds;
	
	TransactionhistoryServiceImp ths;
	
	public OperatorController(DocumentServiceImp ds, TransactionhistoryServiceImp ths) {
		this.ds = ds;
		this.ths = ths;
	}
	
	@GetMapping("/documents")
    public String documents(Model model) {
		model.addAttribute("documents", ds.findAll());
        return "operator/documents";
    }
	
	@GetMapping("/addDocument")
	public String addDocument(Model model) {
		model.addAttribute("document", new Document());
		return "operator/addDocument";
	}
	
	@PostMapping("/addDocument")
	public String saveDocument(Document document, Model model, @RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel"))
			ds.save(document);
		return "redirect:/documents";
	}
	
	@GetMapping("/transactionHistory")
    public String transactionHistory(Model model) {
		model.addAttribute("transactionHistory", ths.findAll());
        return "operator/transactionHistory";
    }
	
	@GetMapping("/addTransactionHistory")
	public String addTransactionHistory(Model model) {
		model.addAttribute("transactionHistory", new Transactionhistory());
		return "operator/addTransactionHistory";
	}
	
	@PostMapping("/addTransactionHistory")
	public String saveTransactionHistory(Transactionhistory transactionHistory, Model model, @RequestParam(value = "action", required = true) String action) {
		if (!action.equals("Cancel"))
			ths.save(transactionHistory);
		return "redirect:/transactionHistory";
	}
	
}
