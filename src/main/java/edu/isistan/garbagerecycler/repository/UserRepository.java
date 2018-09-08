package edu.isistan.garbagerecycler.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.isistan.garbagerecycler.model.User;

@RepositoryRestResource(exported = false)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);

	User findByMail(String mail);
}
