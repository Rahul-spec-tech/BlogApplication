package com.example.PrivateBlogApplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="BlogPost")
public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long BlogId;
	private String Title;
	private String Genre;
	private String Author;
	private String Content;
	private boolean IsPrivatePost;
	public BlogPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlogPost(Long blogId, String title, String genre, String author, String content, boolean isPrivatePost) {
		super();
		BlogId = blogId;
		Title = title;
		Genre = genre;
		Author = author;
		Content = content;
		IsPrivatePost = isPrivatePost;
	}
	public Long getBlogId() {
		return BlogId;
	}
	public void setBlogId(Long blogId) {
		BlogId = blogId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public boolean isIsPrivatePost() {
		return IsPrivatePost;
	}
	public void setIsPrivatePost(boolean isPrivatePost) {
		IsPrivatePost = isPrivatePost;
	}
}
