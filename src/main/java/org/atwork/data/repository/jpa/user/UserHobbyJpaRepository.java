package org.atwork.data.repository.jpa.user;

import org.atwork.entity.user.jpa.UserHobbyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : UserHobby.
 */
public interface UserHobbyJpaRepository extends PagingAndSortingRepository<UserHobbyEntity, Long> {

	UserHobbyEntity findByUserEntityUserId(Long userId);
	UserHobbyEntity findById(Long id);
	void deleteByid(Long userId);
}