package com.ing.careconnect.controller;
/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;
import com.ing.careconnect.service.UserService;

/**
 *   @author Shankar
 * 
 *   This class is used for to check the login function. if success it will return success else it will return 
 *   user invalid
 * 
 */

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * This method is used to validating the user by providing the input as LoginDto
	 * 
	 * @param loginDto
	 * @return LoginResponseDto
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<LoginResponseDto> usersLogin(@RequestBody LoginDto loginDto) {
		 LOGGER.debug("Inside UserController :: usersLogin");	
		LoginResponseDto loginResponseDto = userService.usersLogin(loginDto);
		loginResponseDto.setMessage("Success");
		loginResponseDto.setStatusCode(200);
		return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
	}
}