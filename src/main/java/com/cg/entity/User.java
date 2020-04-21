package com.cg.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_table")
public class User {
	@Id
	@Column (length=20)
	private String userId;
	
	@Column(length=20)
	private String password;
	
	@Column(length=20)
	private String role;
	
	@Column(length=20)
	private String phoneNumber;
	
	@Column(length=20)
	private String email;
	
	/*
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="addressId")
	
	private Address addresses;
	
	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}*/
	
        @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
        private List<Address> address=new ArrayList<Address>();
       
        public List<Address> getAddress() {
		
		System.out.println("INSIDE GET Address");
		return address;
	    }

	   public void setAddress(List<Address> address) {
		this.address = address;
	    }
	    
	    
	    
	    public void addAddress(List<Address> a)
	    { System.out.println("inside ADD PRODUCT");
		this.setAddress(a);
	
		System.out.println(" address added successfully");
	    }
    
	
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Product> product= new ArrayList<Product>();
	
	public List<Product> getProduct() {
		
		System.out.println("INSIDE GET PRODUCT");
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	/////////////////////////////////////////// 
	
	
	
	



	public User() {
		super();
	}
	

	

	public User(String userId, String password, String role, String phoneNumber, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
		}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void addProduct(List<Product> p)
	{ System.out.println("inside ADD PRODUCT");
		this.setProduct(p);
	
		System.out.println(" product added successfully");
	}
	
	
}





