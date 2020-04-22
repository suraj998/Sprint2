package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.AllProducts;
import com.cg.service.AllProductServiceI;

@RestController
public class WishlistController {
	@Autowired
	AllProductServiceI allproductservice;
	
	@PostMapping(value="/addnewproduct",consumes="application/json")
	public String addProduct(@RequestBody AllProducts product)
	{   allproductservice.create(product);
		return "Product Added Successfully";
	}
	
	@GetMapping(value="/allproduct")
	public List<AllProducts> displayAllProducts()
	{
		return allproductservice.reterive();
	}
	
	@GetMapping(value="/product/{id}")
	public AllProducts productById(@PathVariable String id)
	{
		return allproductservice.findById(id);
	}
	

}
