package com.api.bluehappyface.Service;

import com.api.bluehappyface.Models.blog_post;
import com.api.bluehappyface.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements GraphQLQueryResolver {

	@Autowired 
	private PostRepo postRepo;
	
	public List<blog_post> getAllBlogPosts() {
		return postRepo.findAll();
	}
}
