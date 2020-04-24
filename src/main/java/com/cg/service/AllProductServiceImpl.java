package com.cg.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.dao.AllProductDaoI;
import com.cg.entity.AllProducts;
import com.cg.entity.Product;

@Service
public class AllProductServiceImpl implements AllProductServiceI {
    
	@Autowired 
	AllProductDaoI allproductdao;

	@Override
	public void create(AllProducts product) {
		// TODO Auto-generated method stub
		allproductdao.create(product);
	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return allproductdao.reterive();
	}

	@Override
	public AllProducts findById(String id) {
		// TODO Auto-generated method stub
		return allproductdao.findById(id);
	}
	
	

}
