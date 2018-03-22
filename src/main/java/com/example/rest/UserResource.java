package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserResource {
	@Autowired
	UserDaoService service;
	
	@GetMapping("users")
	public List<User> getAll(){
	return	service.getAll();
	}
	@GetMapping("users/{id}")
	public User findOne(@PathVariable Integer id) {
		return service.findOne(id);
	}
	
	@PostMapping("users")
	public void save(@RequestBody User user) {
		service.save(user);
	}
	
	
}
