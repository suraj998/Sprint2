package com.cg.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {
	@Id
	@Column(length=10)
	private String productId;
	
	@Column(length=5)
	private double price;
	
	@Column(length=7)
	private String colour;
	
	@Column(length=10)
	private String dimension;
	
	@Column(length=15)
	private String specification;
	
	@Column(length=10)
	private String manufacturer;
	
	@Column(length=3)
	private int quantity;
	
	@Column(length=10)
	private int productCategory;
	
	@Column(length=10)
	private String productName;
	//////////
	
	//@ManyToMany(fetch=FetchType.LAZY,mappedBy="product")
	@ManyToOne
	@JoinColumn(name="userId")
	private User user ;
	
//    @ManyToMany
//    @JoinTable(name="wishlist00", 
//    joinColumns= {@JoinColumn(name="product_Id")},
//    inverseJoinColumns= {@JoinColumn(name="user_Id")})


	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//////////////////////   
	
	


	public String getProductId() {
		return productId;
	}



	public Product() {
		super();
	}

	
	
	
	public Product(String productId, double price, String colour, String dimension, String specification,
			String manufacturer, int quantity, int productCategory, String productName) {
		super();
		this.productId = productId;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
