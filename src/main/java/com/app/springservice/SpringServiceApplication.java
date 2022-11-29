package com.app.springservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.app.springservice.repository.AdminRepository;
import com.app.springservice.repository.UserRepository;

@SpringBootApplication
@ComponentScan({"com.app.springservice.repository", "com.app.springservice.model", "com.app.springservice.controller", "com.app.springservice", "com.app.springservice.config", "com.app.springservice.service"})
@EnableMongoRepositories(basePackageClasses = {UserRepository.class, AdminRepository.class})
public class SpringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceApplication.class, args);
	}

}
