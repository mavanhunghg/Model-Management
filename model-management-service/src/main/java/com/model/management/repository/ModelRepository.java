package com.model.management.repository;

import com.model.management.entity.Model;
import com.model.management.enums.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long>, JpaSpecificationExecutor<Model> {

    Optional<Model> findByIdAndIsDeletedFalse(Long id);

    List<Model> findByTaskTypeAndIsActiveTrueAndIsDeletedFalse(TaskType taskType);

    List<Model> findByIdInAndIsDeletedFalse(Collection<Long> ids);
}
