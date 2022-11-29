package com.app.springservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.springservice.model.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
	
	//public List<Admin> findAll();
	
	@Query(value="{userid:'?0'}", fields="{userid:1, password:1, id:0}")
	public Admin findAdmins(String userid);
	
	
}
