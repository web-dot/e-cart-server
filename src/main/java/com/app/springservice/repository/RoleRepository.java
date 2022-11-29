package com.app.springservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.springservice.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
