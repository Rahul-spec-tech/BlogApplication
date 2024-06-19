package com.example.BlogApplication.model;

import jakarta.persistence.*;

@Entity
public class PrivatePostAccess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private BlogPost blogPost;

	public PrivatePostAccess(Long id, User user, BlogPost blogPost) {
		super();
		this.Id = id;
		this.user = user;
		this.blogPost = blogPost;
	}

	public PrivatePostAccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BlogPost getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}	
}
