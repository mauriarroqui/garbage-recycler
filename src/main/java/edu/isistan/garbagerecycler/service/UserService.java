package edu.isistan.garbagerecycler.service;

import edu.isistan.garbagerecycler.model.User;

public interface UserService {
	User register(User user);
	
	User findByUsername(String username);
	
	User findByMail(String mail);
}
