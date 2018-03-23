package com.example.rest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWithSpringApplication.class, args);
	}
	//Internationalisation
	@Bean
	public  LocaleResolver localeResolver() {
		
		SessionLocaleResolver localeResolver= new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	//Internationalisation
	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		 messageSource.setBasename("messages");
		 return messageSource;
		
	}
}
