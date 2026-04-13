package com.model.management.controller;

import com.model.management.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/internal/models")
public class InternalModelController {

    private final ModelService modelService;

    public InternalModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/names")
    public ResponseEntity<Map<Long, String>> getModelNames(@RequestParam("ids") List<Long> ids) {
        return ResponseEntity.ok(modelService.getModelNames(ids));
    }
}
