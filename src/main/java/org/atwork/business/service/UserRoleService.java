package org.atwork.business.service;

import java.util.List;

import org.atwork.entity.user.UserRole;

public interface UserRoleService { 

	UserRole addUserRole(UserRole userRole);

	UserRole findById(Long id) ;
	List<UserRole> findAll();
	
	UserRole findByUserId(Long userId);
	
	UserRole update(UserRole userRole);
	
	void delete(Long id);
}
