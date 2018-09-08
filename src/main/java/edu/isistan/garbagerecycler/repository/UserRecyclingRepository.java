package edu.isistan.garbagerecycler.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.isistan.garbagerecycler.model.UserRecycling;

@RepositoryRestResource(exported = false)
public interface UserRecyclingRepository extends PagingAndSortingRepository<UserRecycling, Long> {
	List<UserRecycling> findAllByUserIdOrderByDateDesc(Long userId);
}
