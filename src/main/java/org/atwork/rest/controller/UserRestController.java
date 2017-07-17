package org.atwork.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserService;
import org.atwork.entity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring MVC controller for 'User' management.
 */
@Controller
public class UserRestController {

	@Resource
	private UserService userService;
	
	@RequestMapping( value="/user/getAll",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
		
	@RequestMapping( value="/user/addUser",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public User addUser(@RequestBody User user) {
			return userService.addUser(user);
	}
	
	@RequestMapping( value="/user/updateUser",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public User updateUser(@RequestBody User user) {
			return userService.update(user);
	}
}