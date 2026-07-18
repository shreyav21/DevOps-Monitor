package com.devopsmonitor.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MetricRequestDto {

    @NotNull(message = "CPU usage is required")
    @Min(value = 0, message = "CPU usage cannot be negative")
    @Max(value = 100, message = "CPU usage cannot exceed 100")
    private Double cpuUsage;

    @NotNull(message = "Memory usage is required")
    @Min(value = 0, message = "Memory usage cannot be negative")
    @Max(value = 100, message = "Memory usage cannot exceed 100")
    private Double memoryUsage;

    @NotNull(message = "Disk usage is required")
    @Min(value = 0, message = "Disk usage cannot be negative")
    @Max(value = 100, message = "Disk usage cannot exceed 100")
    private Double diskUsage;

    @NotNull(message = "Network usage is required")
    @Min(value = 0, message = "Network usage cannot be negative")
    private Double networkUsage;

    public MetricRequestDto() {
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
}