package com.devopsmonitor.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "services")
public class ServiceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    private Double cpuUsage;

    private Double memoryUsage;

    private Double uptime;

    private LocalDateTime lastUpdated;

    public ServiceStatus() {
    }

    @PrePersist
    public void prePersist() {
        this.lastUpdated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}