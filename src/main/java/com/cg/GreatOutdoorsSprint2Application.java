package com.cg;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.cg.dao.AddressDaoImpl;
import com.cg.dao.ProductDaoImpl;
import com.cg.dao.UserDaoImpl;
import com.cg.entity.Address;
import com.cg.entity.Product;
import com.cg.entity.User;



@SpringBootApplication
public class GreatOutdoorsSprint2Application implements CommandLineRunner {
   @Autowired
   AddressDaoImpl addressdaoImpl;
   @Autowired
   UserDaoImpl userdaoImpl;
   @Autowired
   ProductDaoImpl productdaoImpl;
	
	public static void main(String[] args)  {
		SpringApplication.run(GreatOutdoorsSprint2Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Address a1=new Address("A102","R101","15","Jaipur","Rajasthan","Udai mod","144411");
		Address a2=new Address("A103","R101","15","Jaipur","Rajasthan","Udai mod","144411");
		Product p1=new Product("P102",100,"Red","dim","spec","xyz",10,10,"abc");
		Product p2=new Product("P103",100,"Red","dim","spec","xyz",10,10,"abc");
			List<Product> pList=new ArrayList<>();
			pList.add(p1);
			pList.add(p2);
			List<Address> aList=new ArrayList<>();
			aList.add(a1);
			aList.add(a2);
		User user1=new User("102","system","Retailer","8745962315","abc@gmail.com");
		user1.addProduct(pList);
		user1.addAddress(aList);
		p1.setUser(user1);
		p2.setUser(user1);
	    a1.setUser(user1);
	    a2.setUser(user1);
		userdaoImpl.createUser(user1);
	       
		///
	}

	




	
}

