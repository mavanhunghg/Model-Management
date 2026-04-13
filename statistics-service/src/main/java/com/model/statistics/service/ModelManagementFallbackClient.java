package com.model.statistics.service;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ModelManagementFallbackClient implements ModelManagementClient {

    @Override
    public Map<Long, String> getModelNames(List<Long> ids) {
        Map<Long, String> fallback = new LinkedHashMap<>();
        if (ids == null) {
            return fallback;
        }

        for (Long id : ids) {
            fallback.put(id, "Model #" + id);
        }

        return fallback;
    }
}
