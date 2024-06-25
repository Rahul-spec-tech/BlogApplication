package com.example.BlogApplication.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApplication.model.BlogPost;
import com.example.BlogApplication.model.PrivatePostAccess;
import com.example.BlogApplication.model.User;
import com.example.BlogApplication.repository.BlogPostRepository;
import com.example.BlogApplication.repository.PrivatePostAccessRepository;
import com.example.BlogApplication.repository.UserRepository;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivatePostAccessRepository privatePostAccessRepository;

    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    public BlogPost save(BlogPost blogPost, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        blogPost.setAuthor(user);
        blogPost.setCreatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public BlogPost update(Long id, BlogPost blogPost) {
        BlogPost existingPost = blogPostRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        existingPost.setTitle(blogPost.getTitle());
        existingPost.setContent(blogPost.getContent());
        existingPost.setPrivate(blogPost.isPrivate());
        return blogPostRepository.save(existingPost);
    }

    public void delete(Long id) {
        blogPostRepository.deleteById(id);
    }

    public List<BlogPost> findPrivatePosts(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return blogPostRepository.findByIsPrivate(true).stream()
            .filter(post -> post.getAuthor().equals(user) || hasAccess(user, post))
            .collect(Collectors.toList());
    }

    public void grantPrivateAccess(Long postId, Long userId) {
        BlogPost post = blogPostRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        PrivatePostAccess access = new PrivatePostAccess();
        access.setUser(user);
        access.setBlogPost(post);
        privatePostAccessRepository.save(access);
    }

    private boolean hasAccess(User user, BlogPost post) {
        return privatePostAccessRepository.findByUserAndBlogPost(user, post).isPresent();
    }
}