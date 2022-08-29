package com.maveric.userservice.repository;

import com.maveric.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Integer> {

}

