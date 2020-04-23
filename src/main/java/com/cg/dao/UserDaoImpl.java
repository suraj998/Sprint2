package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.AllProducts;
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
			
	}
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		String str="SELECT allusers FROM User allusers";
		TypedQuery<User> query=em.createQuery(str,User.class);
		return query.getResultList();
		
	}
	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		User u= em.find(User.class, id);
		System.out.println(u);
		return u;
	}
	@Override
	public boolean checkUid(String uid) {
		// TODO Auto-generated method stub
		System.out.println("IN USERDAO        UID= "+uid);
		if(em.find(User.class, uid)!=null)
		{  System.out.println("true");
			return true;
		}
		else
		{
		return false;
		}
	}

   
}
