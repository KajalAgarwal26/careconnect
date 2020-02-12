package com.ing.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.careconnect.entity.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long>{


}
