package com.example.PrivateBlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PrivateBlogApplication.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{

}
