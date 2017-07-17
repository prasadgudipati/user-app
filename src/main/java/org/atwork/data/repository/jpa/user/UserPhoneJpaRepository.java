package org.atwork.data.repository.jpa.user;

import org.atwork.entity.user.jpa.UserPhoneEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository : UserPhone.
 */
public interface UserPhoneJpaRepository extends PagingAndSortingRepository<UserPhoneEntity, Long> {

	UserPhoneEntity findByUserEntityUserId(Long userId);
	UserPhoneEntity findById(Long id);
	void deleteByid(Long userId);
	void deleteByUserEntityUserIdAndType(Long userId, String type);
}