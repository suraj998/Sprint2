package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Address;
import com.cg.entity.AllProducts;
import com.cg.entity.Product;
import com.cg.entity.User;
import com.cg.exception.ProductException;
import com.cg.service.AllProductServiceI;
import com.cg.service.ProductServiceI;
import com.cg.service.UserServiceI;
@CrossOrigin(origins="*")
@RestController
public class WishlistController {
	@Autowired
	AllProductServiceI allproductservice;
	@Autowired
	UserServiceI userservice;
	@Autowired
	ProductServiceI productservice;

	
	
	//*********************** ALL PRODUCTS OPERATION*********************************
	
	@PostMapping(value="/addnewproduct",consumes="application/json")
	public String addProduct(@RequestBody AllProducts product)
	{   allproductservice.create(product);
		return "Product Added Successfully";
	}
	
	@GetMapping(value="/allproduct")
	public List<AllProducts> displayAllProducts()
	{
		return allproductservice.reterive();
	}
	
	@GetMapping(value="/product/{id}")
	public AllProducts productById(@PathVariable String id) throws ProductException 
	{
	        AllProducts product=allproductservice.findById(id);
	        if(product==null)
	        {   
	        	throw new ProductException("Id not found");	
	        }
	        else 
	    	 return product;
		   
	}
	///////////////////////////////////////////////////////////////////////
	
	//*******************ADDRESS OPERATION******************************
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////
	
	//********************USER OPERATION**************************
	@PostMapping(value="/addUser",consumes="application/json")
	public String addUser(@RequestBody User user)
	{
		Address address=new Address("A118","R101","15","Gwalior","MP","phoolbhG","144411");
		List<Address> addressList=new ArrayList<Address>();
		addressList.add(address);
		user.addAddress(addressList);
		userservice.create(user);
		
		return "User Added Successfully";
	}
	
   @GetMapping(value="/alluser")
   public List<User> displayAllUSer()
   {
	   return userservice.reterive();
   }
   
   @GetMapping(value="/user/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
   public User userById(@PathVariable String id)
   {  
	   System.out.println(userservice.findById(id));
	   return userservice.findById(id);
   }
 //////////////////////////////////////////////////////////////////////////////
   
  //*********Wishlist Operation***************
   
   @GetMapping(value="/user/{uid}/{pid}")
   public void addToWislist(@PathVariable String uid,@PathVariable String pid) throws ProductException
   {   System.out.println("UID= "+uid+" PID= "+pid);
	    if(productservice.checkId(uid, pid))
	    {
	    	Product product=new Product(pid);
	    	product.setUser(userservice.findById(uid));
	    	productservice.create(product);
	    }
	    else
	    {  
	       throw new ProductException("Product is not available");
	    }
   }
   
   @DeleteMapping(value="/user/{uid}/{pid}")
   public void deleteproduct(@PathVariable String uid, @PathVariable String pid)
   {
	   productservice.deleteProduct(uid, pid);
	   System.out.println("Prodcut Deleted from Wishlist");
   }
   
   
   @GetMapping(value="/wishlistproduct/102")
	public List fetchProduct()
	{  System.out.println("inside controller");
//		System.out.println(productservice.reterive(uid));
	    String uid="102";
	    return productservice.reterive(uid);
	}
   
   
   
   ///////////////////////////////////////////

}
