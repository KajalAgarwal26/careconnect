package com.ing.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.careconnect.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{


}
