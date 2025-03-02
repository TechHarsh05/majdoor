package com.emp.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.application.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
