package com.cg.service;

import java.util.List;

import com.cg.entity.AllProducts;


public interface AllProductServiceI {
	public void create(AllProducts product);
	public List reterive();
	public AllProducts findById(String id);
}
