package org.atwork.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.atwork.business.service.UserPhoneService;
import org.atwork.entity.user.UserPhone;
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
 * Spring MVC controller for 'UserPhone' management.
 */
@Controller
public class UserPhoneRestController {

	@Resource
	private UserPhoneService userPhoneService;
	
	@RequestMapping( value="/userPhone/getAll",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserPhone> findAll() {
		return userPhoneService.findAll();
	}

	@RequestMapping( value="/userPhone/updatePhone",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public UserPhone updatePhone(@RequestBody UserPhone userPhone) {
			return userPhoneService.update(userPhone);
	}
	
	@RequestMapping( value="/userPhone/deletePhone/{userid}/{type}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deleteUser(@PathVariable("userid") Long userId, @PathVariable("type") String type) {
		userPhoneService.delete(userId, type);
	}

}