package com.example.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.PrivatePostAccess;

public interface PrivatePostAccessRepository extends JpaRepository<PrivatePostAccess, Long> {

}
