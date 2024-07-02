package com.example.PrivateBlogApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="User")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String Username;
	private String Password;
	private boolean IsPrivate;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(Long id, String username, String password, boolean isPrivate) {
		super();
		Id = id;
		Username = username;
		Password = password;
		IsPrivate = isPrivate;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isIsPrivate() {
		return IsPrivate;
	}
	public void setIsPrivate(boolean isPrivate) {
		IsPrivate = isPrivate;
	}
}
