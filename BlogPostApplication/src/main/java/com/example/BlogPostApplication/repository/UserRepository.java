package com.example.BlogPostApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BlogPostApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}