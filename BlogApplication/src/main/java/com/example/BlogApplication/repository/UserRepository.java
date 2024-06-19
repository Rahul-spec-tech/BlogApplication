package com.example.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
