package com.cg.dao;

import java.util.List;

import com.cg.entity.User;

public interface UserDaoI {
public void createUser(User user);
public void create(User user);
public List reterive();
public User findById(String id);
public boolean checkUid(String uid);
}
