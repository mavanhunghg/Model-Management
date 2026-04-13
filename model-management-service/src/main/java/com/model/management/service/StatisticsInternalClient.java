package com.model.management.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "statistics-internal-client", url = "${services.statistics.base-url:http://localhost:8082}")
public interface StatisticsInternalClient {

    @PostMapping("/internal/training-sessions")
    Map<String, Object> createTrainingSession(@RequestBody Map<String, Object> body);
}
