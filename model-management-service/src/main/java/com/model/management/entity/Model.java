package com.model.management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.model.management.enums.ModelStatus;
import com.model.management.enums.TaskType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "models", indexes = {
        @Index(name = "idx_task_active", columnList = "task_type,is_active")
})
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 50)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false)
    private TaskType taskType;

    @Column(nullable = false, length = 100)
    private String framework;

    @Column(nullable = false, length = 100)
    private String algorithm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModelStatus status = ModelStatus.INACTIVE;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = false;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @JsonManagedReference
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelArtifact> artifacts = new ArrayList<>();

    protected Model() {
    }

    private Model(Builder builder) {
        this.name = builder.name;
        this.version = builder.version;
        this.taskType = builder.taskType;
        this.framework = builder.framework;
        this.algorithm = builder.algorithm;
        this.description = builder.description;
        this.status = ModelStatus.INACTIVE;
        this.isActive = false;
        this.isDeleted = false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getFramework() {
        return framework;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public ModelStatus getStatus() {
        return status;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public List<ModelArtifact> getArtifacts() {
        return artifacts;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(ModelStatus status) {
        this.status = status;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public static final class Builder {
        private String name;
        private String version;
        private TaskType taskType;
        private String framework;
        private String algorithm;
        private String description = "";

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder taskType(TaskType taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder framework(String framework) {
            this.framework = framework;
            return this;
        }

        public Builder algorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public Builder description(String description) {
            if (description != null) {
                this.description = description;
            }
            return this;
        }

        public Model build() {
            if (isBlank(name) || isBlank(version) || taskType == null || isBlank(framework) || isBlank(algorithm)) {
                throw new IllegalArgumentException("Missing required fields to build Model");
            }
            return new Model(this);
        }

        private static boolean isBlank(String value) {
            return value == null || value.trim().isEmpty();
        }
    }
}
