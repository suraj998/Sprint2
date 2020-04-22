package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UserDaoI;
import com.cg.entity.User;
@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	UserDaoI userdao;
	
	
	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		userdao.create(user);

	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return userdao.reterive();
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userdao.findById(id);
	}

}
