package com.ing.careconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.exception.DoctorNotAvailableException;
import com.ing.careconnect.repository.DoctorRepository;
import com.ing.careconnect.util.CareConnectUtil;

@Service
public class  DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository  doctorRepository; 
	
	@Override
	public Optional<Doctors> getBookedSlots(Long doctorId) {
		Optional<Doctors> doctorResp = doctorRepository.findById(doctorId);
		if(!doctorResp.isPresent()) {
			throw new DoctorNotAvailableException(CareConnectUtil.DOCTOR_NOT_AVAILABLE);
		}
		return doctorResp;
	}

}
