package com.practice.practice1.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.practice1.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
