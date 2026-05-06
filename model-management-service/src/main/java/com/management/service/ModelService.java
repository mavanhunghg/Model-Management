package com.management.service;

import com.management.entity.Model;
import com.management.enums.ModelStatus;
import com.management.enums.TaskType;
import com.management.repository.ModelRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> findAll(TaskType taskType, ModelStatus status) {
        Specification<Model> spec = (root, query, cb) -> cb.conjunction();

        if (taskType != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("taskType"), taskType));
        }

        if (status != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("status"), status));
        }

        return modelRepository.findAll(spec);
    }

    public Model findById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Model not found with id=" + id));
    }

    public Model update(Long id, Map<String, Object> body) {
        Model model = findById(id);

        if (body.containsKey("version")) {
            model.setVersion(nonBlankString(body.get("version"), "version"));
        }
        if (body.containsKey("framework")) {
            model.setFramework(nonBlankString(body.get("framework"), "framework"));
        }
        if (body.containsKey("description")) {
            model.setDescription(optionalString(body, "description"));
        }

        return modelRepository.save(model);
    }

    private String nonBlankString(Object value, String fieldName) {
        if (!(value instanceof String str) || str.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid value for field: " + fieldName);
        }
        return str.trim();
    }

    private String optionalString(Map<String, Object> body, String fieldName) {
        Object value = body.get(fieldName);
        if (value == null) {
            return "";
        }
        if (!(value instanceof String str)) {
            throw new IllegalArgumentException("Invalid value for field: " + fieldName);
        }
        return str.trim();
    }

}
