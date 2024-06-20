package com.example.BlogApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{
	List<BlogPost> findByIsPrivate(boolean isPrivate);
}
