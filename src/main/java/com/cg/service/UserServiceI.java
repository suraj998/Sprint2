package com.cg.service;

import java.util.List;

import com.cg.entity.User;

public interface UserServiceI {
	public void create(User user);
	public List reterive();
	public User findById(String id);
}
