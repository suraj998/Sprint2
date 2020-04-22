package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductDaoI;
import com.cg.entity.Product;
@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	ProductDaoI productdao;
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
       productdao.create(product);
	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return productdao.reterive();
	}

	@Override
	public Product findById(int i) {
		// TODO Auto-generated method stub
		return productdao.findById(i);
	}

}
