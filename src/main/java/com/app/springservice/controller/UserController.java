package com.app.springservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springservice.model.Admin;
import com.app.springservice.model.Category;
import com.app.springservice.model.Product;
import com.app.springservice.model.User;
import com.app.springservice.repository.AdminRepository;
import com.app.springservice.repository.CategoryDao;
import com.app.springservice.repository.CategoryRepository;
import com.app.springservice.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	AdminRepository adminrepository;
	
	@Autowired
	CategoryRepository categoryrepository;
	
	@Autowired
	CategoryDao categorydao;
	
	/**
	 * @author Sudp
	 * 
	 * @param user
	 * @return
	 */
	
	@PostMapping("/setNewUser")
	public String setUser(@RequestBody User user) {
		repository.save(user);
		return "User added successfully";
	}
	
	@GetMapping("/getAdminLog/{userid}")
	public Admin getAdminCredentials(@PathVariable String userid) {
		return adminrepository.findAdmins(userid);
	}
	
	
	@PostMapping("/addCategory")
	public String setCategory(@RequestBody Category category) {
		categoryrepository.save(category);
		return "category added successfully";
	}
	
	@GetMapping("/getCategory")
	public List<Category> getCategory(){
		return categoryrepository.findAll();
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public void deleteCategory(@PathVariable String id) {
		System.out.println("in delete category");
		categoryrepository.deleteById(id);
		//return "x deleted";
	}
	
	@PostMapping("/addProduct/{id}")
	public String addProduct(@RequestBody Product product, @PathVariable String id) {
		System.out.println("in addProduct");
		categorydao.addProduct(product, id);
		return "product added";
	}
	
	@PostMapping("/deleteProduct/{id}")
	public String deleteProduct(@RequestBody Product product, @PathVariable String id) {
		System.out.println("in deleteProduct");
		categorydao.deleteProduct(product, id);
		return "product deleted";
	}
	
	
	
	@PostMapping("/userlogin")
	public String login() {
		
		return "login ok";
		
	}
	
}
