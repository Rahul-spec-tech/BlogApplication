package com.example.BlogApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.BlogPost;
import com.example.BlogApplication.model.PrivatePostAccess;
import com.example.BlogApplication.model.User;

public interface PrivatePostAccessRepository extends JpaRepository<PrivatePostAccess, Long> {
	Optional<PrivatePostAccess> findByUserAndBlogPost(User user, BlogPost blogPost);
}
