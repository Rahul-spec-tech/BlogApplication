package com.example.BlogApplication.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogApplication.model.BlogPost;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPost blogPostService;

    @GetMapping
    public List<BlogPost> listPosts() {
        return blogPostService.findAll();
    }

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost blogPost, Authentication authentication) {
        return blogPostService.save(blogPost, authentication.name());
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        return blogPostService.update(id, blogPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        blogPostService.delete(id);
    }

    @GetMapping("/private")
    public List<BlogPost> listPrivatePosts(Authentication authentication) {
        return blogPostService.findPrivatePosts(authentication.name());
    }

    @PostMapping("/private/{postId}/access/{userId}")
    public void grantPrivateAccess(@PathVariable Long postId, @PathVariable Long userId) {
        blogPostService.grantPrivateAccess(postId, userId);
    }
}