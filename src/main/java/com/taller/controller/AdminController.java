package com.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;

import com.taller.model.Product;
import com.taller.model.Productcategory;
import com.taller.model.Productsubcategory;
import com.taller.model.Productvendor;
import com.taller.model.Unitmeasure;
import com.taller.model.Vendor;
import com.taller.service.implementations.ProductServiceImp;
import com.taller.service.implementations.ProductcategoryServiceImp;
import com.taller.service.implementations.ProductsubcategoryServiceImp;
import com.taller.service.implementations.ProductvendorServiceImp;
import com.taller.service.implementations.UnitmeasureServiceImp;
import com.taller.service.implementations.VendorServiceImp;

@Controller
public class AdminController {
	
	//------------------------------------------------------- Services -------------------------------------------------------
	ProductServiceImp ps;
	ProductcategoryServiceImp pcs;
	ProductsubcategoryServiceImp pscs;
	UnitmeasureServiceImp ums;
	
	ProductvendorServiceImp pvs;
	VendorServiceImp vs;
	
	//------------------------------------------------------- Constructor -------------------------------------------------------
	@Autowired
	public AdminController(ProductServiceImp ps, ProductvendorServiceImp pvs, VendorServiceImp vs, UnitmeasureServiceImp ums, ProductcategoryServiceImp pcs, ProductsubcategoryServiceImp pscs) {
		this.ps = ps;
		this.pvs = pvs;
		this.vs = vs;
		this.ums = ums;
		this.pcs = pcs;
		this.pscs = pscs;
	}
	
	//------------------------------------------------------- Index -------------------------------------------------------
	@GetMapping("/product")
    public String products(Model model) {
		model.addAttribute("products", ps.findAll());
        return "admin/products";
    }
	
	@GetMapping("/productvendor")
    public String Productvendors(Model model) {
		model.addAttribute("productvendors", pvs.findAll());
        return "admin/productvendors";
    }
	
	//------------------------------------------------------- Save -------------------------------------------------------
	@GetMapping("/product/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("productcategories", pcs.findAll());
		model.addAttribute("productsubcategories", pscs.findAll());
		model.addAttribute("unitmeasures", ums.findAll());
		return "admin/addProduct";
	}
	
	@PostMapping("/product/add")
	public String saveProduct(@Validated Product product, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("product", new Product());
			return "admin/addProduct";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/product";
		}
		ps.save(product);
		return "redirect:/product";
	}
	
	@GetMapping("/productcategory/add")
	public String addProductcategory(Model model) {
		model.addAttribute("productcategory", new Productcategory());
		return "admin/addProductcategory";
	}
	
	@PostMapping("/productcategory/add")
	public String saveProductcategory(@Validated Productcategory productcategory, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("productcategory", new Productcategory());
			return "admin/addProductcategory";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/productcategory/add";
		}
		pcs.save(productcategory);
		return "redirect:/productcategory/add";
	}
	
	@GetMapping("/productsubcategory/add")
	public String addProductsubcategory(Model model) {
		model.addAttribute("productsubcategory", new Productsubcategory());
		model.addAttribute("productcategories", pcs.findAll());
		return "admin/addProductsubcategory";
	}
	
	@PostMapping("/productsubcategory/add")
	public String saveProductsubcategory(@Validated Productsubcategory productsubcategory, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("productsubcategory", new Productsubcategory());
			model.addAttribute("productcategories", pcs.findAll());
			return "admin/addProductsubcategory";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/productsubcategory/add";
		}
		pscs.save(productsubcategory);
		return "redirect:/productsubcategory/add";
	}
	
	@GetMapping("/unitmeasure/add")
	public String addUnitmeasure(Model model) {
		model.addAttribute("unitmeasure", new Unitmeasure());
		return "admin/addUnitmeasure";
	}
	
	@PostMapping("/unitmeasure/add")
	public String saveUnitmeasure(@Validated Unitmeasure unitmeasure, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("unitmeasure", new Unitmeasure());
			return "admin/addUnitmeasure";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/unitmeasure/add";
		}
		ums.save(unitmeasure);
		return "redirect:/unitmeasure/add";
	}
	
	@GetMapping("/productvendor/add")
	public String addProductvendor(Model model) {
		model.addAttribute("productvendor", new Productvendor());
		return "admin/addProductvendor";
	}
	
	@PostMapping("/productvendor/add")
	public String saveProductvendor(@Validated Productvendor productvendor, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("productvendor", new Productvendor());
			return "admin/addProductvendor";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/productvendor";
		}	
		pvs.save(productvendor);
		return "redirect:/productvendor";
	}
	
	@GetMapping("/vendor/add")
	public String addVendor(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "admin/addVendor";
	}
	
	@PostMapping("/vendor/add")
	public String saveVendor(@Validated Vendor vendor, BindingResult bindingResult, Model model, @RequestParam(value = "action", required = true) String action) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("vendor", new Vendor());
			return "admin/addVendor";
		}
		
		if (action.equals("Cancel")) {
			return "redirect:/vendor/add";
		}	
		vs.save(vendor);
		return "redirect:/vendor/add";
	}
	
	//------------------------------------------------------- Edit -------------------------------------------------------
	
	
	//------------------------------------------------------- Extra methods -------------------------------------------------------
	
}
