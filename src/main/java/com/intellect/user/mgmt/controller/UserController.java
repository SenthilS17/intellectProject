package com.intellect.user.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.user.mgmt.model.User;
import com.intellect.user.mgmt.service.UserService;
import com.intellect.user.mgmt.validator.UserMgmtValidator;
import com.intellect.user.mgmt.vo.UserResponse;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMgmtValidator userMgmtValidator;

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createPerson(@RequestBody User user) {

		List<String[]> validationErrors = userMgmtValidator.validateCreateUser(user);
		UserResponse userResponse = new UserResponse();

		if (validationErrors.size() > 0) {

			userResponse.setResMsg(" User Creation Validation Failed ");
			userResponse.setValErrors(validationErrors);
			return userResponse;
		}

		boolean success = userService.create(user);

		userResponse.setUserId(user.getId());

		if (!success) {
			userResponse.setResMsg("Request Failure");
			userResponse.setValErrors(validationErrors);
			return userResponse;

		}
		userResponse.setResMsg("Request is Sucessfull");
		return userResponse;

	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updatePerson(@RequestBody User user) {
		UserResponse userResponse = new UserResponse();
		boolean success = userService.update(user);

		if (!success) {

			userResponse.setResMsg("Update Failed ");
			userResponse.setUserId(user.getId());
			return userResponse;
		}

		userResponse.setResMsg("Update Successful");
		userResponse.setUserId(user.getId());
		return userResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deletePerson(@RequestBody User user) {

		UserResponse userResponse = new UserResponse();
		boolean success = userService.delete(user);

		if (!success) {

			userResponse.setResMsg("Deletion Failed ");
			userResponse.setUserId(user.getId());
			return userResponse;
		}

		userResponse.setResMsg("User deactivated Successfully");
		userResponse.setUserId(user.getId());
		return userResponse;
	}

}
