package com.devopsmonitor.backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ServiceStatusRequestDto {

    @NotBlank(message = "Service name is required")
    private String name;

    @NotBlank(message = "Service status is required")
    private String status;

    @NotNull
    @Min(0)
    @Max(100)
    private Double cpuUsage;

    @NotNull
    @Min(0)
    @Max(100)
    private Double memoryUsage;

    @NotNull
    @Min(0)
    private Double uptime;

    public ServiceStatusRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Double getUptime() {
        return uptime;
    }

    public void setUptime(Double uptime) {
        this.uptime = uptime;
    }
}