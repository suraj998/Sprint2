package com.cg.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
      EntityManager entitymanager;
      @Autowired
      UserDaoI userdao;
      @Autowired
      AllProductDaoI allproduct;
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
		entitymanager.persist(product);
		
	}

	@Override
	public List reterive(String uid) {
		// TODO Auto-generated method stub
		System.out.println("inside product dao");
		String getwishlistProductQuery="SELECT product.productId FROM Product  product where product.user.userId=:userid";
		TypedQuery<String> wishlistquery=entitymanager.createQuery(getwishlistProductQuery,String.class);
		wishlistquery.setParameter("userid", uid);
		List<String>productIdList=wishlistquery.getResultList();
		System.out.println(productIdList);
		
		String getAllProductQuery="SELECT allproducts FROM AllProducts allproducts";
		TypedQuery<AllProducts> query=entitymanager.createQuery(getAllProductQuery,AllProducts.class);
		//return query.getResultList();
		List<AllProducts> allProducts=query.getResultList();
		
		////List<AllProducts>finalList=allProducts.stream().filter(e->(productIdList.stream().filter(d->d.equals(e.getProductId())).count())<1).collect(Collectors.toList());
		//System.out.println(finalList);
		List<AllProducts> list=allProducts.stream().filter(e->productIdList.stream().anyMatch(f->e.getProductId().equals(f))).collect(Collectors.toList());
		return list;
	}

	@Override
	public Product findById(String id) {
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
		String productQuery="SELECT product FROM Product product WHERE  product.user.userId=:userid  AND product.productId=:productid";
		TypedQuery<Product> query=entitymanager.createQuery(productQuery,Product.class);
		query.setParameter("userid", uid);
		query.setParameter("productid", pid);
		Product product= query.getSingleResult();
		
		System.out.println(product);
//		System.out.println(product.getProductId()+"     "+product.getUser());
		entitymanager.remove(product);
		
	}
   
}
	

