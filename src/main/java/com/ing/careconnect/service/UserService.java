package com.ing.careconnect.service;

import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;

public interface UserService {
	
	 LoginResponseDto usersLogin(LoginDto userDto); 
}
