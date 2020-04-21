package com.cg.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.entity.Product;



public interface ProductDaoI {

	public void createProduct(Product p);
	public void create(Product product);
	public List reterive();
	public Product findById(int i);
}
