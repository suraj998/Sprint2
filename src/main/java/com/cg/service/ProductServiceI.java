package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface ProductServiceI {
	public void create(Product product);
	public List reterive(String uid);
	public Product findById(String pid);
	public boolean checkId(String uid, String pid);
	public void deleteProduct(String uid, String pid);
}
