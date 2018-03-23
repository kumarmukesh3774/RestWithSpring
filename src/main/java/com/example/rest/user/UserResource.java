package com.example.rest.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import  org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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
		User user =service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id :"+id);
		}
		
		//HATEOAS
		Resource<User> resource= new Resource<User>(user);
		ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getAll());
		return user;
	}
	
	@DeleteMapping("users/{id}")
	public User deleteById(@PathVariable Integer id) {
		User user =service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id :"+id);
		}
		return user;
	}
	
	@PostMapping("users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		service.save(user);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
