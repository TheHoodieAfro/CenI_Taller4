package com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	
	//------------------------------------------------------- Services -------------------------------------------------------
	DocumentServiceImp ds;
	
	TransactionhistoryServiceImp ths;
	
	//------------------------------------------------------- Constructor -------------------------------------------------------
	@Autowired
	public OperatorController(DocumentServiceImp ds, TransactionhistoryServiceImp ths) {
		this.ds = ds;
		this.ths = ths;
	}
	
	//------------------------------------------------------- Index -------------------------------------------------------
	@GetMapping("/document")
    public String documents(Model model) {
		model.addAttribute("documents", ds.findAll());
        return "operator/documents";
    }
	
	@GetMapping("/transactionhistory")
    public String transactionhistories(Model model) {
		model.addAttribute("transactionhistories", ths.findAll());
        return "operator/transactionhistories";
    }
	
	//------------------------------------------------------- Save -------------------------------------------------------
	@GetMapping("/document/add")
	public String addDocument(Model model) {
		model.addAttribute("document", new Document());
		return "operator/addDocument";
	}
	
	@PostMapping("/document/add")
	public String saveDocument(@Validated Document document, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("document", new Document());
			return "operator/addDocument";
		}
		
		if (!action.equals("Cancel")) {
			return "redirect:/document";
		}
		ds.save(document);
		return "redirect:/document";
	}
	
	@GetMapping("/transactionhistory/add")
	public String addTransactionHistory(Model model) {
		model.addAttribute("transactionhistory", new Transactionhistory());
		return "operator/addTransactionhistory";
	}
	
	@PostMapping("/transactionhistory/add")
	public String saveTransactionHistory(@Validated Transactionhistory transactionhistory, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("transactionhistory", new Transactionhistory());
			return "operator/addTransactionhistory";
		}
		
		if (!action.equals("Cancel")) {
			return "redirect:/transactionhistory";
		}
		ths.save(transactionhistory);
		return "redirect:/transactionhistory";
	}
	
	//------------------------------------------------------- Edit -------------------------------------------------------
	
	
	//------------------------------------------------------- Extra methods -------------------------------------------------------
		
}
