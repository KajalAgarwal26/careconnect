package com.ing.careconnect.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.constant.CareConnectConstant;
import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.exception.UserNotFoundException;
import com.ing.careconnect.repository.DoctorRepository;
import com.ing.careconnect.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		Users user = userRepository.findByMobileAndPassword(userDto.getMobile(), userDto.getPassword());
		Doctors doctor = new Doctors();
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
