package org.atwork.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserHobbyService;
import org.atwork.business.service.mapping.UserHobbyServiceMapper;
import org.atwork.data.repository.jpa.user.UserHobbyJpaRepository;
import org.atwork.entity.user.UserHobby;
import org.atwork.entity.user.jpa.UserHobbyEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of UserHobbyService
 */
@Component
@Transactional
public class UserHobbyServiceImpl implements UserHobbyService {

	@Resource
	private UserHobbyJpaRepository userHobbyJpaRepository;
	
	@Resource
	private UserHobbyServiceMapper userHobbyServiceMapper;

//	@Override
//	public User findByEmal(String email) {
//		UserEntity userEntity = userJpaRepository.findByEmail(email);
//		return userServiceMapper.mapUserEntityToUser(userEntity);
//	}
//
	@Override
	public List<UserHobby> findAll() {
		Iterable<UserHobbyEntity> entities = userHobbyJpaRepository.findAll();
		List<UserHobby> beans = new ArrayList<UserHobby>();
		for(UserHobbyEntity userHobbyEntity : entities) {
			beans.add(userHobbyServiceMapper.mapUserHobbyEntityToUserHobby(userHobbyEntity));
		}
		return beans;
	}

	@Override
	public UserHobby addUserHobby(UserHobby userHobby) {
		UserHobbyEntity userHobbyEntity = userHobbyJpaRepository.findOne(userHobby.getUserId());
		if( userHobbyEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		userHobbyEntity = new UserHobbyEntity();
		userHobbyServiceMapper.mapUserHobbyToUserHobbyEntity(userHobby, userHobbyEntity);
		UserHobbyEntity userHobbyEntitySaved = userHobbyJpaRepository.save(userHobbyEntity);
		return userHobbyServiceMapper.mapUserHobbyEntityToUserHobby(userHobbyEntitySaved);
	}

	@Override
	public UserHobby update(UserHobby userHobby) {
		UserHobbyEntity userHobbyEntity = userHobbyJpaRepository.findOne(userHobby.getUserId());
		userHobbyServiceMapper.mapUserHobbyToUserHobbyEntity(userHobby, userHobbyEntity);
		UserHobbyEntity userHobbyEntitySaved = userHobbyJpaRepository.save(userHobbyEntity);
		return userHobbyServiceMapper.mapUserHobbyEntityToUserHobby(userHobbyEntitySaved);
	}
	
	@Override
	public void delete(Long id) {
		userHobbyJpaRepository.delete(id);
	}
	
	@Override
	public UserHobby findById(Long id) {
		UserHobbyEntity userHobbyEntity = userHobbyJpaRepository.findById(id);
		return userHobbyServiceMapper.mapUserHobbyEntityToUserHobby(userHobbyEntity);
	}
	
	@Override
	public UserHobby findByUserId(Long userId) {
		UserHobbyEntity userHobbyEntity = userHobbyJpaRepository.findByUserEntityUserId(userId);
		return userHobbyServiceMapper.mapUserHobbyEntityToUserHobby(userHobbyEntity);
	}

}