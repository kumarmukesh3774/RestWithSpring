package com.example.rest.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping("/hello")
	public String greeting() {
		return "Hello";
	}

}
