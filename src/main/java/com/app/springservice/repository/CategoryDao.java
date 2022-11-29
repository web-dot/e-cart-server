package com.app.springservice.repository;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.app.springservice.model.Category;
import com.app.springservice.model.Product;

@Repository
public class CategoryDao {
	
	@Autowired
	MongoOperations template;
	
	public void addProduct(Product product, String id) {
		Category e = template.findOne(new Query(Criteria.where("id").is(id)), Category.class);
		
		if(e!=null) {
			if(e.getProducts()==null) {
				e.setProducts(new ArrayList<Product>());
				e.getProducts().add(product);
			}
			else {
				e.getProducts().add(product);
			}
			
			template.save(e);
		}
		
	}
	
	public void deleteProduct(Product product, String id) {
		Category e = template.findOne(new Query(Criteria.where("id").is(id)), Category.class);
		
		if(e!=null) {
			if(e.getProducts()==null) {
				e.setProducts(new ArrayList<Product>());
				e.getProducts().add(product);
			}
			else {
				if(e.getProducts().contains(product)) {}
				System.err.println(product);
				e.getProducts().remove(product);
				template.save(e);
			}
			
		}
		
	}
	
	
}
