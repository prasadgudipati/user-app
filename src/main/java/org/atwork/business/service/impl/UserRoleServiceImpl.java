package org.atwork.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserRoleService;
import org.atwork.business.service.mapping.UserRoleServiceMapper;
import org.atwork.data.repository.jpa.user.UserRoleJpaRepository;
import org.atwork.entity.user.UserRole;
import org.atwork.entity.user.jpa.UserRoleEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of UserRoleService
 */
@Component
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleJpaRepository userRoleJpaRepository;
	
	@Resource
	private UserRoleServiceMapper userRoleServiceMapper;

//	@Override
//	public User findByEmal(String email) {
//		UserEntity userEntity = userJpaRepository.findByEmail(email);
//		return userServiceMapper.mapUserEntityToUser(userEntity);
//	}
//
	@Override
	public List<UserRole> findAll() {
		Iterable<UserRoleEntity> entities = userRoleJpaRepository.findAll();
		List<UserRole> beans = new ArrayList<UserRole>();
		for(UserRoleEntity userRoleEntity : entities) {
			beans.add(userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity));
		}
		return beans;
	}

	@Override
	public UserRole addUserRole(UserRole userRole) {
		UserRoleEntity userRoleEntity = userRoleJpaRepository.findOne(userRole.getUserId());
		if( userRoleEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		userRoleEntity = new UserRoleEntity();
		userRoleServiceMapper.mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		UserRoleEntity userRoleEntitySaved = userRoleJpaRepository.save(userRoleEntity);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved);
	}

	@Override
	public UserRole update(UserRole userRole) {
		UserRoleEntity userRoleEntity = userRoleJpaRepository.findOne(userRole.getUserId());
		userRoleServiceMapper.mapUserRoleToUserRoleEntity(userRole, userRoleEntity);
		UserRoleEntity userRoleEntitySaved = userRoleJpaRepository.save(userRoleEntity);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntitySaved);
	}
	
	@Override
	public void delete(Long id) {
		userRoleJpaRepository.delete(id);
	}
	
	@Override
	public UserRole findById(Long id) {
		UserRoleEntity userRoleEntity = userRoleJpaRepository.findByRoleId(id);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity);
	}
	
	@Override
	public UserRole findByUserId(Long userId) {
		UserRoleEntity userRoleEntity = userRoleJpaRepository.findByUserEntityUserId(userId);
		return userRoleServiceMapper.mapUserRoleEntityToUserRole(userRoleEntity);
	}

}