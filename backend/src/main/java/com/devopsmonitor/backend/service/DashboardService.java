package com.devopsmonitor.backend.service;

import com.devopsmonitor.backend.dto.DashboardHistoryDto;
import com.devopsmonitor.backend.dto.DashboardSummaryDto;
import com.devopsmonitor.backend.entity.Metric;
import com.devopsmonitor.backend.repository.MetricRepository;
import org.springframework.stereotype.Service;
import com.devopsmonitor.backend.dto.AlertResponseDto;
import com.devopsmonitor.backend.dto.DashboardResponseDto;
import com.devopsmonitor.backend.dto.ServiceStatusResponseDto;
import com.devopsmonitor.backend.repository.AlertRepository;
import com.devopsmonitor.backend.repository.ServiceStatusRepository;

import java.util.List;

@Service
public class DashboardService {

    private final MetricRepository metricRepository;
    private final ServiceStatusRepository serviceRepository;
    private final AlertRepository alertRepository;

    public DashboardService(
            MetricRepository metricRepository,
            ServiceStatusRepository serviceRepository,
            AlertRepository alertRepository) {

        this.metricRepository = metricRepository;
        this.serviceRepository = serviceRepository;
        this.alertRepository = alertRepository;
    }

    public DashboardSummaryDto getDashboardSummary() {

        Metric latestMetric = metricRepository
                .findTopByOrderByCreatedAtDesc()
                .orElseThrow(() -> new RuntimeException("No metrics found"));

        DashboardSummaryDto summary = new DashboardSummaryDto();

        summary.setCpuUsage(latestMetric.getCpuUsage());
        summary.setMemoryUsage(latestMetric.getMemoryUsage());
        summary.setDiskUsage(latestMetric.getDiskUsage());
        summary.setNetworkUsage(latestMetric.getNetworkUsage());
        summary.setLastUpdated(latestMetric.getCreatedAt());

        return summary;
    }

    public List<DashboardHistoryDto> getDashboardHistory() {

        return metricRepository.findAll()
                .stream()
                .map(metric -> {

                    DashboardHistoryDto dto = new DashboardHistoryDto();

                    dto.setCpuUsage(metric.getCpuUsage());
                    dto.setMemoryUsage(metric.getMemoryUsage());
                    dto.setDiskUsage(metric.getDiskUsage());
                    dto.setNetworkUsage(metric.getNetworkUsage());
                    dto.setTimestamp(metric.getCreatedAt());

                    return dto;

                })
                .toList();
    }
    public DashboardResponseDto getDashboard() {

        DashboardResponseDto response = new DashboardResponseDto();

        response.setSummary(getDashboardSummary());

        response.setHistory(getDashboardHistory());

        List<ServiceStatusResponseDto> services = serviceRepository.findAll()
                .stream()
                .map(service -> {

                    ServiceStatusResponseDto dto = new ServiceStatusResponseDto();

                    dto.setId(service.getId());
                    dto.setName(service.getName());
                    dto.setStatus(service.getStatus());
                    dto.setCpuUsage(service.getCpuUsage());
                    dto.setMemoryUsage(service.getMemoryUsage());
                    dto.setUptime(service.getUptime());
                    dto.setLastUpdated(service.getLastUpdated());

                    return dto;

                })
                .toList();

        response.setServices(services);

        List<AlertResponseDto> alerts = alertRepository.findAll()
                .stream()
                .map(alert -> {

                    AlertResponseDto dto = new AlertResponseDto();

                    dto.setId(alert.getId());
                    dto.setTitle(alert.getTitle());
                    dto.setMessage(alert.getMessage());
                    dto.setSeverity(alert.getSeverity());
                    dto.setSource(alert.getSource());
                    dto.setStatus(alert.getStatus());
                    dto.setCreatedAt(alert.getCreatedAt());

                    return dto;

                })
                .toList();

        response.setAlerts(alerts);

        return response;
    }
}