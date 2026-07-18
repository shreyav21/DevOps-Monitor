package com.devopsmonitor.backend.dto;

import java.time.LocalDateTime;

public class MetricResponseDto {

    private Long id;
    private Double cpuUsage;
    private Double memoryUsage;
    private Double diskUsage;
    private Double networkUsage;
    private LocalDateTime createdAt;

    public MetricResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Double getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Double diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Double getNetworkUsage() {
        return networkUsage;
    }

    public void setNetworkUsage(Double networkUsage) {
        this.networkUsage = networkUsage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}