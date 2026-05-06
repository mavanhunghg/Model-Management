package com.model.management.controller;

import com.model.management.entity.Model;
import com.model.management.enums.ModelStatus;
import com.model.management.enums.TaskType;
import com.model.management.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<Model>> getAll(
            @RequestParam(required = false) TaskType taskType,
            @RequestParam(required = false) ModelStatus status
    ) {
        return ResponseEntity.ok(modelService.findAll(taskType, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> update(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        return ResponseEntity.ok(modelService.update(id, body));
    }

}
