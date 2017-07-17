package org.atwork.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserService;
import org.atwork.business.service.mapping.UserServiceMapper;
import org.atwork.data.repository.jpa.user.UserJpaRepository;
import org.atwork.entity.user.User;
import org.atwork.entity.user.jpa.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of UserService
 */
@Component
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserJpaRepository userJpaRepository;
	
	@Resource
	private UserServiceMapper userServiceMapper;

	@Override
	public User findByEmal( String email  ) {
		UserEntity userEntity = userJpaRepository.findByEmail(email);
		return userServiceMapper.mapUserEntityToUser(userEntity);
	}

	@Override
	public List<User> findAll() {
		Iterable<UserEntity> entities = userJpaRepository.findAll();
		List<User> beans = new ArrayList<User>();
		for(UserEntity userEntity : entities) {
			beans.add(userServiceMapper.mapUserEntityToUser(userEntity));
		}
		return beans;
	}

	@Override
	public User addUser(User user) {
		UserEntity userEntity = userJpaRepository.findOne(user.getUserId());
		if( userEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		userEntity = new UserEntity();
		userServiceMapper.mapUserToUserEntity(user, userEntity);
		UserEntity userEntitySaved = userJpaRepository.save(userEntity);
		return userServiceMapper.mapUserEntityToUser(userEntitySaved);
	}

	@Override
	public User update(User user) {
		UserEntity userEntity = userJpaRepository.findOne(user.getUserId());
		userServiceMapper.mapUserToUserEntity(user, userEntity);
		UserEntity userEntitySaved = userJpaRepository.save(userEntity);
		return userServiceMapper.mapUserEntityToUser(userEntitySaved);
	}
	
	@Override
	public void delete(Long userId) {
		userJpaRepository.deleteByUserId(userId);
	}
}