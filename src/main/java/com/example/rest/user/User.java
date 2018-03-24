package com.example.rest.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All Details about the User")
public class User {

	Integer id;
	@Size(min=2,message="Name Should have at least 2 characters")
	@ApiModelProperty(notes="Name Should have at least 2 characters")
	String name;
	@Past
	@ApiModelProperty(notes="DOB Should be Past date")
	Date dob;
	
	public User() {
		super();
	}
	
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
