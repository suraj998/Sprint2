package com.cg.dao;

import java.util.List;

import com.cg.entity.Address;

public interface AddressDaoI  {
	public void create(Address address);
	public List reterive();
	public Address findById(String id);

}
