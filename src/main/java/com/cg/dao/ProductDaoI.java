package com.cg.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.entity.Product;



public interface ProductDaoI {

	public void create(Product product);
	public List reterive(String uid);
	public Product findById(String id);
	public boolean checkId(String uid, String pid);
	public void deleteProduct(String uid, String pid);
}
