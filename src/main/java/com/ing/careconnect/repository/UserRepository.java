package com.ing.careconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.careconnect.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{


}
