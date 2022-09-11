package com.api.bluehappyface.Repo;

import com.api.bluehappyface.Models.DevEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepo extends JpaRepository<DevEntity, Long> {}