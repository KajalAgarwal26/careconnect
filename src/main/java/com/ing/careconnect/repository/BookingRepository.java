package com.ing.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.careconnect.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Long>{


}
