package com.cg.dao;

import java.util.List;

import com.cg.entity.AllProducts;


public interface AllProductDaoI {
	public void create(AllProducts product);
	public List reterive();
	public AllProducts findById(int i);
}
