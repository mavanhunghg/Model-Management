package com.model.management.repository;

import com.model.management.entity.ModelArtifact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelArtifactRepository extends JpaRepository<ModelArtifact, Long> {

    List<ModelArtifact> findByModelIdAndModelIsDeletedFalse(Long modelId);
}
