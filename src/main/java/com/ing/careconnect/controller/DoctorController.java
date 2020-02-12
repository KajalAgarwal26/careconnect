package com.ing.careconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	

}
