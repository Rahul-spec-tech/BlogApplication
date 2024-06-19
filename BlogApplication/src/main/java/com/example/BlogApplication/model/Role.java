package com.example.BlogApplication.model;

import jakarta.persistence.*;
@Entity
public class Role {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long Id;
	 private String name;
	 public Role(Long id, String name) {
		super();
		this.Id = id;
		this.name = name;
	 }
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 

}
