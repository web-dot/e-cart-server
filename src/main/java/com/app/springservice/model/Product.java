package com.app.springservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")
public class Product {

	String id;
	String name;
	int price;
	int instock;
	
	public Product(String name, int price, int instock) {
		super();
		this.name = name;
		this.price = price;
		this.instock = instock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}
	
	
	
	
}
