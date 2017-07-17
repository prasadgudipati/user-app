package org.atwork.business.service.mapping;

import org.atwork.entity.user.UserHobby;
import org.atwork.entity.user.jpa.UserHobbyEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UserHobbyServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public UserHobbyServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'UserHobbyEntity' to 'UserHobby'
	 * @param userHobbyEntity
	 */
	public UserHobby mapUserHobbyEntityToUserHobby(UserHobbyEntity userHobbyEntity) {
		if(userHobbyEntity == null) {
			return null;
		}

		//--- Generic mapping 
		UserHobby userHobby = map(userHobbyEntity, UserHobby.class);

		return userHobby;
	}
	
	/**
	 * Mapping from 'UserHobby' to 'UserHobbyEntity'
	 * @param userHobby
	 * @param userHobbyEntity
	 */
	public void mapUserHobbyToUserHobbyEntity(UserHobby userHobby, UserHobbyEntity userHobbyEntity) {
		if(userHobby == null) {
			return;
		}
		//--- Generic mapping 
		map(userHobby, userHobbyEntity);
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