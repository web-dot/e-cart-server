package com.app.springservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.springservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByEmail(String email);
	
	
}	
