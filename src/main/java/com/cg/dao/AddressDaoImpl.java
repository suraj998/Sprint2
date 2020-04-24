package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Address;
@Repository
@Transactional
public class AddressDaoImpl implements AddressDaoI{
	@PersistenceContext
    EntityManager entitymanager;

	@Override
	public void create(Address address) {
		// TODO Auto-generated method stub
		//create address
	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
