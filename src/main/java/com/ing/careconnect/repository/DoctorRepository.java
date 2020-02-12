package com.ing.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.careconnect.entity.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long>{


}
