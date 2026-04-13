package com.model.statistics.service;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.enums.TaskType;
import com.model.statistics.enums.TrainingStatus;
import com.model.statistics.repository.TrainingSessionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;

    public TrainingSessionService(TrainingSessionRepository trainingSessionRepository) {
        this.trainingSessionRepository = trainingSessionRepository;
    }

    public Page<TrainingSession> findAll(TaskType taskType, TrainingStatus status, Pageable pageable) {
        Specification<TrainingSession> spec = Specification.where(null);

        if (taskType != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("taskType"), taskType));
        }

        if (status != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("status"), status));
        }

        return trainingSessionRepository.findAll(spec, pageable);
    }

    public TrainingSession findById(Long id) {
        return trainingSessionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Training session not found with id=" + id));
    }

    public long totalSessions() {
        return trainingSessionRepository.count();
    }

    public long completedSessions() {
        return trainingSessionRepository.countByStatus(TrainingStatus.COMPLETED);
    }

    public long totalDurationSeconds() {
        return trainingSessionRepository.sumDurationSeconds();
    }

    public TrainingSession maxAccuracySession() {
        return trainingSessionRepository.findFirstByOrderByAccuracyDesc().orElse(null);
    }

    public Map<String, Object> emptySummary() {
        return Map.of(
                "totalSessions", 0,
                "totalDurationSeconds", 0,
                "bestModelId", null,
                "bestModelName", null,
                "bestAccuracy", null,
                "successRate", 0.0
        );
    }
}
