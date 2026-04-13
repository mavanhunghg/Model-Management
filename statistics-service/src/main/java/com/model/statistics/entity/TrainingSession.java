package com.model.statistics.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.statistics.enums.TaskType;
import com.model.statistics.enums.TrainingStatus;
import com.model.statistics.enums.TrainingType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "training_sessions", indexes = {
        @Index(name = "idx_model_id", columnList = "model_id"),
        @Index(name = "idx_status", columnList = "status")
})
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_id", nullable = false)
    private Long modelId;

    @Column(name = "dataset_id", nullable = false)
    private Long datasetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false)
    private TaskType taskType;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_type", nullable = false)
    private TrainingType trainingType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrainingStatus status;

    @Column
    private Float accuracy;

    @Column
    private Float loss;

    @Column(name = "precision_val")
    private Float precision;

    @Column
    private Float recall;

    @Column(name = "f1_score")
    private Float f1Score;

    @Column(name = "duration_seconds")
    private Long durationSeconds;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private String config;

    @Column(name = "train_log_path")
    private String trainLogPath;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Transient
    private String modelName;

    public Long getId() {
        return id;
    }

    public Long getModelId() {
        return modelId;
    }

    public Long getDatasetId() {
        return datasetId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public Float getAccuracy() {
        return accuracy;
    }

    public Float getLoss() {
        return loss;
    }

    public Float getPrecision() {
        return precision;
    }

    public Float getRecall() {
        return recall;
    }

    public Float getF1Score() {
        return f1Score;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getTrainLogPath() {
        return trainLogPath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
