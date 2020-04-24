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
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return productdao.findById(id);
	}

	@Override
	public boolean checkId(String uid, String pid)
	{
		System.out.println("IN PRODUCT SERVICE        UID= "+uid+" PID= "+pid);
		if(productdao.checkId(uid, pid))
		{
			return true;
		}
		else {
		return false;
		}
    }

	@Override
	public void deleteProduct(String uid, String pid) {
		// TODO Auto-generated method stub
		productdao.deleteProduct(uid, pid);
	}
}
