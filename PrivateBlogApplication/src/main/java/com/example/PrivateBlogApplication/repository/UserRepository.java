package com.example.PrivateBlogApplication.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PrivateBlogApplication.model.UserRole;

public interface UserRepository extends JpaRepository<UserRole ,Long>{
	Optional<UserRole> findByUsername(String username);
}
