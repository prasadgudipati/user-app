package org.atwork.data.repository.jpa.user;

import org.atwork.entity.user.jpa.UserRoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : UserRole.
 */
public interface UserRoleJpaRepository extends PagingAndSortingRepository<UserRoleEntity, Long> {

	UserRoleEntity findByUserEntityUserId(Long userId);
	UserRoleEntity findByRoleId(Long roleId);
	void deleteByRoleId(Long roleId);
}