package org.atwork.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserHobbyService;
import org.atwork.entity.user.UserHobby;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring MVC controller for 'UserHobby' management.
 */
@Controller
public class UserHobbyRestController {

	@Resource
	private UserHobbyService userHobbyService;
	
	@RequestMapping( value="/userHobby/getAll",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserHobby> findAll() {
		return userHobbyService.findAll();
	}
		
	@RequestMapping( value="/userHobby/getuserId/{email}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserHobby findOne(@PathVariable("userId") Long userId) {
		return userHobbyService.findByUserId(userId);
	}
	
}