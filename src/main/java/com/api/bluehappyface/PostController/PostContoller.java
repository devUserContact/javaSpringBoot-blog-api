package com.api.bluehappyface.PostController;

import com.api.bluehappyface.Models.*;
import com.api.bluehappyface.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;

import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostContoller implements GraphQLQueryResolver {

	@Autowired
	private DevRepo devRepo;
  private ArtRepo artRepo;

	PostContoller(DevRepo devRepo, ArtRepo artRepo) {
		this.devRepo = devRepo;
    this.artRepo = artRepo;
	}

	public List<DevEntity> devGetAllBlogPosts() {
		return devRepo.findAll();
	}
  public List<ArtEntity> artGetAllBlogPosts() {
    return artRepo.findAll();
  }

}
