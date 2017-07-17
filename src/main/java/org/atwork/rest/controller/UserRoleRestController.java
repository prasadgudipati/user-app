package org.atwork.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserRoleService;
import org.atwork.entity.user.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring MVC controller for 'UserRole' management.
 */
@Controller
public class UserRoleRestController {

	@Resource
	private UserRoleService userRoleService;
	
	@RequestMapping( value="/userRole/getAll",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserRole> findAll() {
		return userRoleService.findAll();
	}
		
	@RequestMapping( value="/userRole/getuserId/{email}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserRole findOne(@PathVariable("userId") Long userId) {
		return userRoleService.findByUserId(userId);
	}
	
}