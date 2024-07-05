package com.example.BlogPostApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogPostApplication.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}