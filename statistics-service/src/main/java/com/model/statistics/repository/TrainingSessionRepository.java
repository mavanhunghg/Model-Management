package com.model.statistics.repository;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.enums.TrainingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long>, JpaSpecificationExecutor<TrainingSession> {

    long countByStatus(TrainingStatus status);

    @Query("select coalesce(sum(t.durationSeconds), 0) from TrainingSession t")
    Long sumDurationSeconds();

    Optional<TrainingSession> findFirstByOrderByAccuracyDesc();
}
