package com.api.bluehappyface.Repo;

import com.api.bluehappyface.Models.ArtEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepo extends JpaRepository<ArtEntity, Long> {
}
