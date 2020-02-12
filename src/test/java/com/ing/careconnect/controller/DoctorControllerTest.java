package com.ing.careconnect.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.careconnect.service.DoctorService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorControllerTest {
	
	 @InjectMocks 
	  DoctorController doctorController;
	  
	  @Mock 
	  DoctorService doctorService;
	  
	  @Test 
	  public void testusersLoginPossitive() {
		  
	  }
}
