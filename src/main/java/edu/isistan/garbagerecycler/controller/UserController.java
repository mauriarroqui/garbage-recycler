package edu.isistan.garbagerecycler.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.isistan.garbagerecycler.dto.Recycling;
import edu.isistan.garbagerecycler.exceptions.UserNotFoundException;
import edu.isistan.garbagerecycler.model.User;
import edu.isistan.garbagerecycler.model.UserRecycling;
import edu.isistan.garbagerecycler.service.UserRecyclingService;
import edu.isistan.garbagerecycler.service.UserService;

/**
 * 
 * Rest Controller for all Rest Api related to User
 * 
 * @author mauriarroqui
 *
 */


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRecyclingService userRecyclingService;
	
	@PostMapping(path = "/api/users")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User newUser = userService.register(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(newUser);
	}
	
	@PostMapping(path = "/api/users/{username}/recycling/")
	public ResponseEntity<UserRecycling> addRecyclingToUser(@PathVariable(value = "username") String username,@RequestBody UserRecycling userRecycling){
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UserNotFoundException();
		}
		userRecycling.setUser(user);
		UserRecycling newUserRecycling = userRecyclingService.save(userRecycling);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUserRecycling.getId())
				.toUri();
		return ResponseEntity.created(location).body(newUserRecycling);
	}
	
	@GetMapping(path = "/api/users/{username}/recycling/")
	public ResponseEntity<List<UserRecycling>> getUsetRecyclingByUser(@PathVariable(value = "username") String username){
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return ResponseEntity.ok(userRecyclingService.getAllUserRecyclingByUserId(user.getId()));
	}
	
	
	@GetMapping(path = "/api/users/{username}/total/")
	public ResponseEntity<Recycling> getUserTotalRecycling(@PathVariable(value = "username") String username){
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UserNotFoundException();
		}
		return ResponseEntity.ok(userRecyclingService.getAllUserRecyclingTotal(user.getId()));
	}
	
}
