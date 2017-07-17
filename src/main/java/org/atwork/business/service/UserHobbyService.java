package org.atwork.business.service;

import java.util.List;

import org.atwork.entity.user.UserHobby;

public interface UserHobbyService { 

	UserHobby addUserHobby(UserHobby userHobby);

	UserHobby findById(Long id) ;
	List<UserHobby> findAll();
	
	UserHobby findByUserId(Long userId);
	
	UserHobby update(UserHobby userHobby);
	
	void delete(Long id);
}
