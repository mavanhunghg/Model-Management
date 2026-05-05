package com.model.statistics.controller;

import com.model.statistics.entity.TrainingSession;
import com.model.statistics.service.TrainingSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/internal/training-sessions")
public class InternalTrainingSessionController {

    private final TrainingSessionService trainingSessionService;

    public InternalTrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }

    @PostMapping
    public ResponseEntity<TrainingSession> create(@RequestBody Map<String, Object> body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingSessionService.createInternal(body));
    }
}
