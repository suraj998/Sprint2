package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.AllProducts;
import com.cg.entity.Product;
@Repository
@Transactional
public class AllProductDaoImpl implements AllProductDaoI {
    @PersistenceContext
    EntityManager entitymanager;
	@Override
	public void create(AllProducts product) {
		// TODO Auto-generated method stub
       entitymanager.persist(product);
       System.out.println("Product inserted in ALLPRODUCT Table");
	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AllProducts findById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
