package com.api.bluehappyface.Repo;

import com.api.bluehappyface.Models.blog_post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<blog_post, Long> {}
