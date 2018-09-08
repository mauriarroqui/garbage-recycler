package edu.isistan.garbagerecycler.service;

import java.util.List;

import edu.isistan.garbagerecycler.dto.Recycling;
import edu.isistan.garbagerecycler.model.UserRecycling;

public interface UserRecyclingService {
	UserRecycling save(UserRecycling userRecycling);
	
	List<UserRecycling> getAllUserRecyclingByUserId(Long userId);
	
	Recycling getAllUserRecyclingTotal(Long userId);
	
}
