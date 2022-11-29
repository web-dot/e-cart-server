package com.app.springservice.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users_collection")
public class User {
	
	@Id
	private String id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING.ASCENDING, dropDups=true )
	
	private String email;
	private String name;
	private String password;
	private String mobile;
	private String billingaddress;
	private boolean enabled;
	
	@DBRef
	private Set<Role> roles;
	
	
	public User(String name, String email, String password, String mobile, String billingaddress) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.billingaddress = billingaddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return billingaddress;
	}

	public void setAddress(String address) {
		this.billingaddress = address;
	}
	
	public boolean isEnabled() {
	    return enabled;
	}

	public void setEnabled(boolean enabled) {
	    this.enabled = enabled;
	}
	
	public Set<Role> getRoles() {
	    return roles;
	}

	public void setRoles(Set<Role> roles) {
	    this.roles = roles;
	}
	
	
}
