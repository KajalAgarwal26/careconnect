package com.ing.careconnect.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.constant.CareConnectConstant;
import com.ing.careconnect.controller.UserController;
import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.exception.UserNotFoundException;
import com.ing.careconnect.repository.DoctorRepository;
import com.ing.careconnect.repository.UserRepository;

/**
 * @author Shankar
 * 
 *         This class used to check login weather the user is patient or doctor
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	DoctorRepository doctorRepository;

	/**
	 * @author Shankar
	 *
	 *         Method is used to check the input Login and if login success means it
	 *         will return success else it will throw Invalid User
	 *
	 * @param LoginDto
	 * @return LoginResponseDto
	 */

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		Users user = userRepository.findByMobileAndPassword(userDto.getMobile(), userDto.getPassword());
		Doctors doctor = new Doctors();
		LOGGER.debug("Inside UserService :: usersLogin");
		if (!Objects.isNull(user)) {
			if (user.getType().equalsIgnoreCase(CareConnectConstant.DOCTOR_TYPE)) {
				doctor = doctorRepository.findByUserId(user.getUserId());
			}

		} else {
			throw new UserNotFoundException("Invalid User");
		}

		LoginResponseDto responseDto = new LoginResponseDto();
		responseDto.setDoctorId(doctor.getDoctorId());
		return responseDto;
	}
}
