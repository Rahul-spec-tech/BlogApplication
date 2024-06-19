package com.example.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
