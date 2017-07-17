package org.atwork.data.repository.jpa.user;

import org.atwork.entity.user.jpa.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : User.
 */
public interface UserJpaRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	void deleteByUserId(Long userId);
}