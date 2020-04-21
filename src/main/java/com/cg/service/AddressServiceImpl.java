package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.dao.AddressDaoI;
import com.cg.entity.Address;

public class AddressServiceImpl implements AddressServiceI {
 
	@Autowired
	AddressDaoI addressdao;
	
	@Override
	public void create(Address address) {
		// TODO Auto-generated method stub
		addressdao.create(address);

	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return addressdao.reterive();
	}

	@Override
	public Address findById(int i) {
		// TODO Auto-generated method stub
		return addressdao.findById(i);
	}

}
