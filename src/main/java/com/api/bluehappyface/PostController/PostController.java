package com.api.bluehappyface.PostController;

import com.api.bluehappyface.DataSourceConfig.SwitchDataSource;
import com.api.bluehappyface.Models.DevEntity;
import com.api.bluehappyface.Models.ArtEntity;
import com.api.bluehappyface.Repo.DevRepo;
import com.api.bluehappyface.Repo.ArtRepo;
import org.springframework.beans.factory.annotation.Autowired;

import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostController implements GraphQLQueryResolver {

	@Autowired
	private DevRepo devRepo;
	private ArtRepo artRepo;

	PostController(DevRepo devRepo, ArtRepo artRepo) {
		this.devRepo = devRepo;
		this.artRepo = artRepo;
	}

	@SwitchDataSource("dev")
	public List<DevEntity> devGetAllBlogPosts() {
		return devRepo.findAll();
	}

	@SwitchDataSource("art")
	public List<ArtEntity> artGetAllBlogPosts() {
		return artRepo.findAll();
	}
}
