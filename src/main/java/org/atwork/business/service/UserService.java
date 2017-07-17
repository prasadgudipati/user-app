package org.atwork.business.service;

import java.util.List;

import org.atwork.entity.user.User;

/**
 * Business Service Interface for entity User.
 */
public interface UserService { 

	User addUser(User user);
	/**
	 * Loads an entity from the database using its Primary Key
	 * @param email
	 * @return entity
	 */
	User findByEmal( String email  ) ;


	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<User> findAll();
	
	User update(User user);
	
	void delete(Long userId);
}
