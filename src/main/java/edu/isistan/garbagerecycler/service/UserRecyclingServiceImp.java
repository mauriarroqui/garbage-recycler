package edu.isistan.garbagerecycler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
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
		List<UserRecycling> userRecyclingList = userRecyclingRepository.findAllByUserIdOrderByDateDesc(userId);
		
		
		int bottles = 0;
		int cans = 0;
		int glass = 0;
		int paperboard = 0;
		int tetrabriks = 0;
		
		for (UserRecycling userRecycling : userRecyclingList) {
			bottles += userRecycling.getBottles();
			cans += userRecycling.getCans();
			glass += userRecycling.getGlass();
			paperboard += userRecycling.getPaperboard();
			tetrabriks += userRecycling.getTetrabriks();
		}
		
		float tons = bottles+cans+glass+paperboard+tetrabriks; //TODO Correct the formula
		Recycling out = new Recycling(tons, bottles, tetrabriks, glass, paperboard, cans);
		return out;
	}

}
