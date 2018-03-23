package com.example.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class UserDaoService {
	
	static List <User> users= new ArrayList<User>();
	static int userCount=3;
	static {
		users.add(new User(1,"mukesh",new Date()));		
		users.add(new User(2,"rohan",new Date()));
		users.add(new User(3,"Ram",new Date()));
	}
	
	
	public List<User> getAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user; 
	}
	public User findOne(int id) {
		
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
			
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> itr=users.iterator();
		while(itr.hasNext()) {
			User user=itr.next();
			if(user.getId()==id) {
				users.remove(user);
				return user;
			}
			
		}
		return null;
	}

	
}
