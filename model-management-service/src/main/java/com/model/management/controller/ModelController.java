package com.model.management.controller;

import com.model.management.entity.Model;
import com.model.management.enums.ModelStatus;
import com.model.management.enums.TaskType;
import com.model.management.service.ModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<Model>> getAll(
            @RequestParam(required = false) TaskType taskType,
            @RequestParam(required = false) ModelStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(modelService.findAll(taskType, status, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Model> create(@RequestBody Map<String, Object> body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelService.create(body));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> update(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        return ResponseEntity.ok(modelService.update(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        modelService.softDelete(id);
        return ResponseEntity.ok(Map.of("message", "Model deleted successfully"));
    }

    @PostMapping("/{id}/retrain")
    public ResponseEntity<Model> retrain(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modelService.retrain(id, body));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<Model> activate(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.activate(id));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Model> deactivate(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.deactivate(id));
    }
}
