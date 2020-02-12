package com.ing.careconnect.service;

import java.util.Optional;

import com.ing.careconnect.entity.Doctors;

public interface DoctorService {

	Optional<Doctors> getBookedSlots(Long doctorId);

}
