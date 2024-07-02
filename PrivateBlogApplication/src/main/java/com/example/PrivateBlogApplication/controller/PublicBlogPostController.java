package com.example.PrivateBlogApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home/public")
public class PublicBlogPostController {
	@GetMapping("/post")
	public String getPublicPost() {
		return "Public_Post";
	}

}
