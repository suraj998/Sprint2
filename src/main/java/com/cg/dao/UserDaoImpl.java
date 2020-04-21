package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDaoI{
	@PersistenceContext
    EntityManager em;
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("INSIDE create user function");
		em.persist(user);
		System.out.println("persist successflly");
		em.flush();
		
	}
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User findById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
