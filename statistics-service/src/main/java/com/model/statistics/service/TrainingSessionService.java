package com.model.statistics.service;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.enums.TaskType;
import com.model.statistics.enums.TrainingStatus;
import com.model.statistics.enums.TrainingType;
import com.model.statistics.repository.TrainingSessionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
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

    public TrainingSession createInternal(Map<String, Object> body) {
        TrainingSession session = new TrainingSession();
        session.setModelId(requiredLong(body, "modelId"));
        session.setDatasetId(requiredLong(body, "datasetId"));
        session.setParentModelId(optionalLong(body, "parentModelId"));
        session.setTaskType(requiredEnum(body, "taskType", TaskType.class));
        session.setTrainingType(requiredEnum(body, "trainingType", TrainingType.class));
        session.setStatus(requiredEnum(body, "status", TrainingStatus.class));
        session.setConfig(optionalString(body, "config"));
        session.setStartTime(LocalDateTime.now());
        return trainingSessionRepository.save(session);
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
        Map<String, Object> map = new HashMap<>();
        map.put("totalSessions", 0);
        map.put("totalDurationSeconds", 0);
        map.put("bestModelId", null);
        map.put("bestModelName", null);
        map.put("bestAccuracy", null);
        map.put("successRate", 0.0);
        return map;
    }

    private String requiredString(Map<String, Object> body, String fieldName) {
        if (!body.containsKey(fieldName)) {
            throw new IllegalArgumentException("Missing required field: " + fieldName);
        }
        Object value = body.get(fieldName);
        if (!(value instanceof String str) || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid value for field: " + fieldName);
        }
        return str.trim();
    }

    private String optionalString(Map<String, Object> body, String fieldName) {
        Object value = body.get(fieldName);
        if (value == null) {
            return "";
        }
        return String.valueOf(value).trim();
    }

    private Long optionalLong(Map<String, Object> body, String fieldName) {
        if (!body.containsKey(fieldName) || body.get(fieldName) == null) {
            return null;
        }
        Object value = body.get(fieldName);
        if (value instanceof Number number) {
            return number.longValue();
        }
        if (value instanceof String str) {
            try {
                return Long.parseLong(str.trim());
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Invalid value for field: " + fieldName);
            }
        }
        throw new IllegalArgumentException("Invalid value for field: " + fieldName);
    }

    private Long requiredLong(Map<String, Object> body, String fieldName) {
        if (!body.containsKey(fieldName) || body.get(fieldName) == null) {
            throw new IllegalArgumentException("Missing required field: " + fieldName);
        }
        Object value = body.get(fieldName);
        if (value instanceof Number number) {
            long longValue = number.longValue();
            if (longValue <= 0) {
                throw new IllegalArgumentException("Invalid value for field: " + fieldName);
            }
            return longValue;
        }
        if (value instanceof String str) {
            try {
                long longValue = Long.parseLong(str.trim());
                if (longValue <= 0) {
                    throw new IllegalArgumentException("Invalid value for field: " + fieldName);
                }
                return longValue;
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Invalid value for field: " + fieldName);
            }
        }
        throw new IllegalArgumentException("Invalid value for field: " + fieldName);
    }

    private <E extends Enum<E>> E requiredEnum(Map<String, Object> body, String fieldName, Class<E> enumType) {
        String raw = requiredString(body, fieldName);
        try {
            return Enum.valueOf(enumType, raw.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid enum value for field: " + fieldName);
        }
    }
}
