package com.model.management.service;

import com.model.management.entity.Model;
import com.model.management.enums.ModelStatus;
import com.model.management.enums.TaskType;
import com.model.management.exception.BadRequestException;
import com.model.management.exception.ConflictException;
import com.model.management.exception.ResourceNotFoundException;
import com.model.management.repository.ModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Page<Model> findAll(TaskType taskType, ModelStatus status, Pageable pageable) {
        Specification<Model> spec = (root, query, cb) -> cb.isFalse(root.get("isDeleted"));

        if (taskType != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("taskType"), taskType));
        }

        if (status != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("status"), status));
        }

        return modelRepository.findAll(spec, pageable);
    }

    public Model findById(Long id) {
        return modelRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Model not found with id=" + id));
    }

    public Model create(Map<String, Object> body) {
        Model model = Model.builder()
                .name(requiredString(body, "name"))
                .version(requiredString(body, "version"))
                .taskType(requiredEnum(body, "taskType", TaskType.class))
                .framework(requiredString(body, "framework"))
                .algorithm(requiredString(body, "algorithm"))
                .description(optionalString(body, "description"))
                .build();
        return modelRepository.save(model);
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

    public void softDelete(Long id) {
        Model model = findById(id);
        if (model.isActive()) {
            throw new ConflictException("Cannot delete an active model. Deactivate it first.");
        }

        model.setDeleted(true);
        model.setStatus(ModelStatus.DEPRECATED);
        modelRepository.save(model);
    }

    @Transactional
    public Model activate(Long id) {
        Model target = findById(id);

        List<Model> currentActives = modelRepository.findByTaskTypeAndIsActiveTrueAndIsDeletedFalse(target.getTaskType());
        for (Model current : currentActives) {
            current.setActive(false);
            current.setStatus(ModelStatus.INACTIVE);
        }
        modelRepository.saveAll(currentActives);

        target.setActive(true);
        target.setStatus(ModelStatus.ACTIVE);
        return modelRepository.save(target);
    }

    public Model deactivate(Long id) {
        Model model = findById(id);
        model.setActive(false);
        model.setStatus(ModelStatus.INACTIVE);
        return modelRepository.save(model);
    }

    public Map<Long, String> getModelNames(Collection<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Map.of();
        }

        List<Model> models = modelRepository.findByIdInAndIsDeletedFalse(ids);

        Map<Long, String> map = models.stream()
                .collect(Collectors.toMap(Model::getId, Model::getName, (a, b) -> a, LinkedHashMap::new));

        for (Long id : ids) {
            map.putIfAbsent(id, "Model #" + id);
        }
        return map;
    }

    private String requiredString(Map<String, Object> body, String fieldName) {
        if (!body.containsKey(fieldName)) {
            throw new BadRequestException("Missing required field: " + fieldName);
        }
        return nonBlankString(body.get(fieldName), fieldName);
    }

    private String nonBlankString(Object value, String fieldName) {
        if (!(value instanceof String str) || str.trim().isEmpty()) {
            throw new BadRequestException("Invalid value for field: " + fieldName);
        }
        return str.trim();
    }

    private String optionalString(Map<String, Object> body, String fieldName) {
        Object value = body.get(fieldName);
        if (value == null) {
            return "";
        }
        if (!(value instanceof String str)) {
            throw new BadRequestException("Invalid value for field: " + fieldName);
        }
        return str.trim();
    }

    private <E extends Enum<E>> E requiredEnum(Map<String, Object> body, String fieldName, Class<E> enumType) {
        String raw = requiredString(body, fieldName);
        try {
            return Enum.valueOf(enumType, raw.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid enum value for " + fieldName + ": " + raw);
        }
    }
}
