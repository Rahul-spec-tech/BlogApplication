package com.example.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BlogApplication.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{

}
