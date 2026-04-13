package com.model.statistics.controller;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.enums.TaskType;
import com.model.statistics.enums.TrainingStatus;
import com.model.statistics.service.StatisticFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticFacade statisticFacade;

    public StatisticsController(StatisticFacade statisticFacade) {
        this.statisticFacade = statisticFacade;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        return ResponseEntity.ok(statisticFacade.getSummary());
    }

    @GetMapping("/sessions")
    public ResponseEntity<Page<TrainingSession>> getSessionPage(
            @RequestParam(required = false) TaskType taskType,
            @RequestParam(required = false) TrainingStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(statisticFacade.getSessionPage(taskType, status, pageable));
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<TrainingSession> getSessionById(@PathVariable Long id) {
        return ResponseEntity.ok(statisticFacade.getSessionById(id));
    }
}
