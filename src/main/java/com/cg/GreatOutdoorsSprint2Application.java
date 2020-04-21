package com.cg;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.cg.dao.AllProductDaoI;

import com.cg.dao.UserDaoI;
import com.cg.dao.UserDaoImpl;
import com.cg.entity.Address;
import com.cg.entity.AllProducts;
import com.cg.entity.Product;
import com.cg.entity.User;



@SpringBootApplication
public class GreatOutdoorsSprint2Application implements CommandLineRunner {
  
   @Autowired
   UserDaoI userdaoImpl;
   @Autowired
   AllProductDaoI allproductdao;
   
	
	public static void main(String[] args)  {
		SpringApplication.run(GreatOutdoorsSprint2Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Address a1=new Address("A111","R101","15","Jaipur","Rajasthan","Udai mod","144411");
		Address a2=new Address("A113","R101","15","Jaipur","Rajasthan","Udai mod","144411");
		List<Address> aList=new ArrayList<>();
		aList.add(a1);
		aList.add(a2);
		Product p1=new Product(0001,"P105");
		Product p2=new Product(0002,"P106");
			List<Product> pList=new ArrayList<>();
			pList.add(p1);
			pList.add(p2);
			
		User user1=new User("107","system","Retailer","8745962315","abc@gmail.com");
		user1.addProduct(pList);
		user1.addAddress(aList);
		p1.setUser(user1);
		p2.setUser(user1);
	    a1.setUser(user1);
	    a2.setUser(user1);
		userdaoImpl.createUser(user1);
		
		//AllProducts product1=new AllProducts("P102",100,"Red","dim","spec","xyz",10,10,"Bat"); 
		//allproductdao.create(product1);
		
	       
		///
	}

	




	
}

