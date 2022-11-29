package com.app.springservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admin_data")
public class Admin {
	
	String id;
	String userid;
	String password;
	
	
	public Admin(String id, String userid, String password) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
