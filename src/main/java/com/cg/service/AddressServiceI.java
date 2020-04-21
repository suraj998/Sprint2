package com.cg.service;

import java.util.List;

import com.cg.entity.Address;

public interface AddressServiceI {
	public void create(Address address);
	public List reterive();
	public Address findById(int i);
}
