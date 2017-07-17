package org.atwork.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserPhoneService;
import org.atwork.business.service.mapping.UserPhoneServiceMapper;
import org.atwork.data.repository.jpa.user.UserPhoneJpaRepository;
import org.atwork.entity.user.UserPhone;
import org.atwork.entity.user.jpa.UserPhoneEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of UserPhoneService
 */
@Component
@Transactional
public class UserPhoneServiceImpl implements UserPhoneService {

	@Resource
	private UserPhoneJpaRepository userPhoneJpaRepository;
	
	@Resource
	private UserPhoneServiceMapper userPhoneServiceMapper;

//	@Override
//	public User findByEmal(String email) {
//		UserEntity userEntity = userJpaRepository.findByEmail(email);
//		return userServiceMapper.mapUserEntityToUser(userEntity);
//	}
//
	@Override
	public List<UserPhone> findAll() {
		Iterable<UserPhoneEntity> entities = userPhoneJpaRepository.findAll();
		List<UserPhone> beans = new ArrayList<UserPhone>();
		for(UserPhoneEntity userPhoneEntity : entities) {
			beans.add(userPhoneServiceMapper.mapUserPhoneEntityToUserPhone(userPhoneEntity));
		}
		return beans;
	}

	@Override
	public UserPhone addUserPhone(UserPhone userPhone) {
		UserPhoneEntity userPhoneEntity = userPhoneJpaRepository.findOne(userPhone.getUserId());
		if( userPhoneEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		userPhoneEntity = new UserPhoneEntity();
		userPhoneServiceMapper.mapUserPhoneToUserPhoneEntity(userPhone, userPhoneEntity);
		UserPhoneEntity userPhoneEntitySaved = userPhoneJpaRepository.save(userPhoneEntity);
		return userPhoneServiceMapper.mapUserPhoneEntityToUserPhone(userPhoneEntitySaved);
	}

	@Override
	public UserPhone update(UserPhone userPhone) {
		UserPhoneEntity userPhoneEntity = userPhoneJpaRepository.findOne(userPhone.getId());
		userPhoneServiceMapper.mapUserPhoneToUserPhoneEntity(userPhone, userPhoneEntity);
		UserPhoneEntity userPhoneEntitySaved = userPhoneJpaRepository.save(userPhoneEntity);
		return userPhoneServiceMapper.mapUserPhoneEntityToUserPhone(userPhoneEntitySaved);
	}
	
	@Override
	public void delete(Long id) {
		userPhoneJpaRepository.delete(id);
	}
	
	@Override
	public void delete(Long userId, String type) {
		userPhoneJpaRepository.deleteByUserEntityUserIdAndType(userId, type);
	}
	
	@Override
	public UserPhone findById(Long id) {
		UserPhoneEntity userPhoneEntity = userPhoneJpaRepository.findById(id);
		return userPhoneServiceMapper.mapUserPhoneEntityToUserPhone(userPhoneEntity);
	}
	
	@Override
	public UserPhone findByUserId(Long userId) {
		UserPhoneEntity userPhoneEntity = userPhoneJpaRepository.findByUserEntityUserId(userId);
		return userPhoneServiceMapper.mapUserPhoneEntityToUserPhone(userPhoneEntity);
	}

}