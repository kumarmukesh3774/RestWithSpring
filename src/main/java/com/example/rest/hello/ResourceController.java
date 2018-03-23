package com.example.rest.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	//Internationalisation
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello")
	public String greeting() {
		return "Hello";
	}
	
	
	//Internationalisation
	@GetMapping("/international-greeting")
	public String greetingInternational(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
