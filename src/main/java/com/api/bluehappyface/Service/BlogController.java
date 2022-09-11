package com.api.bluehappyface.Service;

import com.api.bluehappyface.Models.DevEntity;
import com.api.bluehappyface.Repo.DevRepo;
import org.springframework.beans.factory.annotation.Autowired;

import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogController implements GraphQLQueryResolver {

	private final DevRepo devRepo;

	@Autowired
	BlogController(DevRepo devRepo) {
		this.devRepo = devRepo;
	}

	public List<DevEntity> devGetAllBlogPosts() {
		return devRepo.findAll();
	}
}
