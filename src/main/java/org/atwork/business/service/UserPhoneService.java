package org.atwork.business.service;

import java.util.List;

import org.atwork.entity.user.UserPhone;

public interface UserPhoneService { 

	UserPhone addUserPhone(UserPhone userPhone);

	UserPhone findById(Long id) ;
	List<UserPhone> findAll();
	
	UserPhone findByUserId(Long userId);
	
	UserPhone update(UserPhone userPhone);
	void delete(Long id);
	
	void delete(Long id, String type);
}
