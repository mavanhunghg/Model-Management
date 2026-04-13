package com.model.statistics.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "model-management-client", url = "${services.model-management.base-url:http://localhost:8081}", fallback = ModelManagementFallbackClient.class)
public interface ModelManagementClient {

    @GetMapping("/internal/models/names")
    Map<Long, String> getModelNames(@RequestParam("ids") List<Long> ids);
}
