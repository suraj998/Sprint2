package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface ProductServiceI {
	public void create(Product product);
	public List reterive();
	public Product findById(int i);
}
