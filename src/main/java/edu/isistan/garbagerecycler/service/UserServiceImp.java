package edu.isistan.garbagerecycler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.isistan.garbagerecycler.model.User;
import edu.isistan.garbagerecycler.repository.UserRepository;

/**
 * UserServiceImp for User management
 * @author mauriarroqui
 *
 */

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}

}
