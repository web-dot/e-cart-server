package com.app.springservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.springservice.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
