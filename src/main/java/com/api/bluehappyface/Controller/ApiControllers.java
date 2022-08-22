package com.api.bluehappyface.Controller;

import com.api.bluehappyface.Repo.PostRepo;
import com.api.bluehappyface.Models.blog_post;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class ApiControllers {

	@Autowired 
	private PostRepo postRepo;

	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome";
	}

	@GetMapping(value = "/posts")		
	public List<blog_post> getPosts(){
		return postRepo.findAll();
	}
}
