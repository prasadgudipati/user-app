package org.atwork.business.service.mapping;

import org.atwork.entity.user.UserPhone;
import org.atwork.entity.user.jpa.UserEntity;
import org.atwork.entity.user.jpa.UserPhoneEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UserPhoneServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UserPhoneServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'NMyuspprefEntity' to 'NMyusppref'
	 * @param nMyuspprefEntity
	 */
	public UserPhone mapUserPhoneEntityToUserPhone(UserPhoneEntity userPhoneEntity) {
		if(userPhoneEntity == null) {
			return null;
		}

		//--- Generic mapping 
		UserPhone userPhone = map(userPhoneEntity, UserPhone.class);

		//--- Link mapping ( link to UserPone )
		if(userPhoneEntity.getUserEntity() != null) {
			userPhone.setUserId(userPhoneEntity.getUserEntity().getUserId());
		}
		return userPhone;
	}
	
	/**
	 * Mapping from 'UserPhone' to 'UserPhoneEntity'
	 * @param userPhone
	 * @param userPhoneEntity
	 */
	public void mapUserPhoneToUserPhoneEntity(UserPhone userPhone, UserPhoneEntity userPhoneEntity) {
		if(userPhone == null) {
			return;
		}
		//--- Generic mapping 
		map(userPhone, userPhoneEntity);

		//--- Link mapping ( link : nMyusppref )
		if( hasLinkToUser(userPhone) ) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(userPhone.getUserId());
			userPhoneEntity.setUserEntity(userEntity);
		} else {
			userPhoneEntity.setUserEntity(null);
		}
	}
	
	/**
	 * Verify that User id is valid.
	 * @param User User
	 * @return boolean
	 */
	private boolean hasLinkToUser(UserPhone userPhone) {
		if(userPhone.getUserId() != null) {
			return true;
		}
		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}