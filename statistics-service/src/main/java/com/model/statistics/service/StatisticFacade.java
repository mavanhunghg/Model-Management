package com.model.statistics.service;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.enums.TaskType;
import com.model.statistics.enums.TrainingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StatisticFacade {

    private final TrainingSessionService trainingSessionService;
    private final ModelNameResolver modelNameResolver;

    public StatisticFacade(TrainingSessionService trainingSessionService, ModelNameResolver modelNameResolver) {
        this.trainingSessionService = trainingSessionService;
        this.modelNameResolver = modelNameResolver;
    }

    public Map<String, Object> getSummary() {
        long total = trainingSessionService.totalSessions();
        if (total == 0) {
            return trainingSessionService.emptySummary();
        }

        long completed = trainingSessionService.completedSessions();
        long totalDuration = trainingSessionService.totalDurationSeconds();
        TrainingSession bestSession = trainingSessionService.maxAccuracySession();

        Long bestModelId = bestSession != null ? bestSession.getModelId() : null;
        Float bestAccuracy = bestSession != null ? bestSession.getAccuracy() : null;
        String bestModelName = null;

        if (bestModelId != null) {
            bestModelName = modelNameResolver.resolveNames(List.of(bestModelId)).get(bestModelId);
        }

        double successRate = total == 0 ? 0.0 : ((double) completed * 100.0) / total;

        return Map.of(
                "totalSessions", total,
                "totalDurationSeconds", totalDuration,
                "bestModelId", bestModelId,
                "bestModelName", bestModelName,
                "bestAccuracy", bestAccuracy,
                "successRate", successRate
        );
    }

    public Page<TrainingSession> getSessionPage(TaskType taskType, TrainingStatus status, Pageable pageable) {
        Page<TrainingSession> page = trainingSessionService.findAll(taskType, status, pageable);
        enrichSessionsWithNames(page.getContent());
        return page;
    }

    public TrainingSession getSessionById(Long id) {
        TrainingSession session = trainingSessionService.findById(id);
        enrichSessionsWithNames(List.of(session));
        return session;
    }

    private void enrichSessionsWithNames(List<TrainingSession> sessions) {
        Set<Long> ids = new LinkedHashSet<>();
        for (TrainingSession session : sessions) {
            ids.add(session.getModelId());
        }

        Map<Long, String> modelNames = modelNameResolver.resolveNames(ids);
        for (TrainingSession session : sessions) {
            session.setModelName(modelNames.getOrDefault(session.getModelId(), "Model #" + session.getModelId()));
        }
    }
}
