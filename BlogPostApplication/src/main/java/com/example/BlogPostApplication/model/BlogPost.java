package com.example.BlogPostApplication.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private boolean isPrivate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany
    @JoinTable(
            name = "private_post_access",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> allowedUsers;

	public BlogPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogPost(Long id, String title, String content, boolean isPrivate, User author, Set<User> allowedUsers) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.isPrivate = isPrivate;
		this.author = author;
		this.allowedUsers = allowedUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<User> getAllowedUsers() {
		return allowedUsers;
	}

	public void setAllowedUsers(Set<User> allowedUsers) {
		this.allowedUsers = allowedUsers;
	}
    
}