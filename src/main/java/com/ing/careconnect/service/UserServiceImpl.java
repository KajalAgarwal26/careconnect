package com.ing.careconnect.service;

import org.springframework.stereotype.Service;

import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.exception.UserNotFoundException;
import com.ing.careconnect.repository.UserRepository;
import com.ing.careconnect.util.LibraryUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		List<Users> users = userRepository.findAll();
		
		LoginResponseDto responseDto = new LoginResponseDto();

		/*
		 * for (Users user : users) {
		 * if((userDto.getEmail().equalsIgnoreCase(user.getUserEmail()))&&
		 * (user.getUserPassword()).equals(userDto.getPassword())) {
		 * responseDto.setMessage(LibraryUtil.LOGIN_SUCCESS);
		 * responseDto.setStatusCode(HttpStatus.OK.value());
		 * responseDto.setUserId(user.getUserId()); return responseDto; } else { throw
		 * new UserNotFoundException(LibraryUtil.INVALID_LOGIN); } }
		 */
		return responseDto;
	}

}
