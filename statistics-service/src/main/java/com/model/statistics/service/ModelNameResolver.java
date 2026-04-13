package com.model.statistics.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModelNameResolver {

    private final ModelManagementClient modelManagementClient;

    public ModelNameResolver(ModelManagementClient modelManagementClient) {
        this.modelManagementClient = modelManagementClient;
    }

    public Map<Long, String> resolveNames(Collection<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Map.of();
        }

        List<Long> uniqueIds = new ArrayList<>(ids.stream().distinct().toList());
        Map<Long, String> result;
        try {
            result = modelManagementClient.getModelNames(uniqueIds);
        } catch (Exception ex) {
            result = new LinkedHashMap<>();
        }

        if (result == null) {
            result = new LinkedHashMap<>();
        }

        for (Long id : uniqueIds) {
            result.putIfAbsent(id, "Model #" + id);
        }

        return result;
    }
}
