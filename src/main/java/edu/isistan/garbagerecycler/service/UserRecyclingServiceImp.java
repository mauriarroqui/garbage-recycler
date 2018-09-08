package edu.isistan.garbagerecycler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.isistan.garbagerecycler.dto.Recycling;
import edu.isistan.garbagerecycler.model.UserRecycling;
import edu.isistan.garbagerecycler.repository.UserRecyclingRepository;

/**
 * 
 * @author mauriarroqui
 *
 */

@Service
public class UserRecyclingServiceImp implements UserRecyclingService {

	UserRecyclingRepository userRecyclingRepository;
	
	@Override
	public UserRecycling save(UserRecycling userRecycling) {
		return userRecyclingRepository.save(userRecycling);
	}

	@Override
	public List<UserRecycling> getAllUserRecyclingByUserId(Long userId) {
		return userRecyclingRepository.findAllByUserIdOrderByDateDesc(userId);
	}

	
	@Override
	public Recycling getAllUserRecyclingTotal(Long userId) {
		// TODO Sumar todo lo reciclado para un usaurio 
		return new Recycling(10,1,2,3,4,5);
	}

}
