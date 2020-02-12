package com.ing.careconnect.controller;

import java.util.ArrayList;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ing.careconnect.dto.LoginDto;
import com.ing.careconnect.dto.LoginResponseDto;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.service.UserService;





@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	  @InjectMocks 
	  UserController userController;
	  
	  @Mock 
	  UserService userService;
	  
	
	 @Test public void testusersLoginPossitive() {
	  
	  List<Users> listUsers=new ArrayList<>(); Users user=new Users();
	  user.setUserId(new Long(1)); user.setMobile(289734L);
	  user.setEmail("a@b.com"); user.setFirstName("Kavi");
	  user.setLastName("Shankar"); user.setPassword("8283jks");
	  user.setType("doctor"); listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); loginDto.setMobile(user.getMobile());
	  loginDto.setPassword(user.getPassword());
	  
	  LoginResponseDto loginResponseDto=new LoginResponseDto();
	  loginResponseDto.setMessage("Login Success");
	  loginResponseDto.setStatusCode(200); loginResponseDto.setDoctorId(new
	  Long(1));
	  
	  Mockito.when(userService.usersLogin(loginDto)).thenReturn(loginResponseDto);
	  
	  ResponseEntity<LoginResponseDto> usersLogin =
	  userController.usersLogin(loginDto);
	  
	  Assert.assertEquals(HttpStatus.OK,usersLogin.getStatusCode()); }
	 
	  
	  
	  @Test
	  public void testusersLoginNegative() {
	  List<Users> listUsers=new ArrayList<>(); Users user=new Users();
	  user.setUserId(new Long(1)); user.setMobile(289734L);
	  user.setEmail("a@b.com"); user.setFirstName("rajesh");
	  user.setLastName("Kannan"); user.setPassword("8283jks");
	  user.setType("Doctor"); listUsers.add(user);
	  
	  LoginDto loginDto=new LoginDto(); ;
	  
	  LoginResponseDto loginResponseDto=new LoginResponseDto();
	  loginResponseDto.setMessage("Login Failed");
	  loginResponseDto.setStatusCode(400); 
	  loginResponseDto.setDoctorId(new
	  Long(1));
	  
	  Mockito.when(userService.usersLogin(loginDto)).thenReturn(loginResponseDto);
	  
	  loginResponseDto =userService.usersLogin(loginDto);
	  Assert.assertEquals(new Integer(400), loginResponseDto.getStatusCode());
	  }
	  
	  
	 	  

}
