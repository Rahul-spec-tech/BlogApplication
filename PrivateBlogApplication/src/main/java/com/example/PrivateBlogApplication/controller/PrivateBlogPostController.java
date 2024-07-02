package com.example.PrivateBlogApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("home/private")
public class PrivateBlogPostController {
	@GetMapping("/post")
	public String PrivatePost() {
		return "Private_Post";
	}
}
