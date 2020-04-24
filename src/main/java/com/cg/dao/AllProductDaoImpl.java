package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		String getAllProductQuery="SELECT allproducts FROM AllProducts allproducts";
		TypedQuery<AllProducts> query=entitymanager.createQuery(getAllProductQuery,AllProducts.class);
		return query.getResultList();
		
	}

	@Override
	public AllProducts findById(String id) {
		// TODO Auto-generated method stub
		return entitymanager.find(AllProducts.class, id);
	}

	@Override
	public boolean checkPid(String pid) {
		// TODO Auto-generated method stub
		System.out.println("IN ALL PRODUCT DAO    PID= "+pid);
		if(entitymanager.find(AllProducts.class, pid)!=null)
		{
			System.out.println("true");
			return true;
		}
		else
		{
		return false;
		}
	}

}
