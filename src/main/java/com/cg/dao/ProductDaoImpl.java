package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.AllProducts;
import com.cg.entity.Product;
import com.cg.entity.User;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDaoI{
      @PersistenceContext
      EntityManager em;
      @Autowired
      UserDaoI userdao;
      @Autowired
      AllProductDaoI allproduct;
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		em.persist(product);
		
	}

	@Override
	public List reterive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(String i) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean checkId(String uid, String pid) 
	{
		// TODO Auto-generated method stub
		
		System.out.println("IN PRODUCT DAO        UID= "+uid+" PID= "+pid);
		if(userdao.checkUid(uid)==true && allproduct.checkPid(pid)==true)
		{  System.out.println("true");
			return true;
		}
		else if(userdao.checkUid(uid)==true && allproduct.checkPid(pid)==false)
		{ System.out.println("Product id does not found");
			return false;
		}
		else if(userdao.checkUid(uid)==false && allproduct.checkPid(pid)==true)
		{ System.out.println("User id does  not found");
			return false;
		}
		else
		{
			System.out.println("Both User ID and Product id not found");
			return false;
		}

	}

	@Override
	public void deleteProduct(String uid, String pid) {
		// TODO Auto-generated method stub
		String userStr="SELECT user FROM User user WHERE userId="+uid;
		TypedQuery<User> userquery=em.createQuery(userStr,User.class);
		User userResult= userquery.getSingleResult();
		System.out.println(userResult);
		String str="SELECT product FROM Product product WHERE  user="+uid+" AND productId="+"'"+pid+"'";
		TypedQuery<Product> query=em.createQuery(str,Product.class);
		Product product= query.getSingleResult();
		System.out.println(product);
//		System.out.println(product.getProductId()+"     "+product.getUser());
    	em.remove(product);
		
	}
   
}
	

