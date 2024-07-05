package com.example.BlogPostApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.BlogPostApplication.model.BlogPost;
import com.example.BlogPostApplication.model.User;
import com.example.BlogPostApplication.repository.BlogPostRepository;
import com.example.BlogPostApplication.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/public")
    public List<BlogPost> getPublicPosts() {
        return blogPostRepository.findByIsPrivateFalse();
    }

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost blogPost, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        blogPost.setAuthor(user);
        return blogPostRepository.save(blogPost);
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost blogPostDetails, Authentication authentication) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));

        if (!blogPost.getAuthor().equals(authentication.getPrincipal())) {
            throw new AccessDeniedException("You do not have permission to update this post");
        }

        blogPost.setTitle(blogPostDetails.getTitle());
        blogPost.setContent(blogPostDetails.getContent());
        blogPost.setPrivate(blogPostDetails.isPrivate());

        return blogPostRepository.save(blogPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id, Authentication authentication) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BlogPost", "id", id));

        if (!blogPost.getAuthor().equals(authentication.getPrincipal())) {
            throw new AccessDeniedException("You do not have permission to delete this post");
        }

        blogPostRepository.delete(blogPost);

        return ResponseEntity.ok().build();
    }
}