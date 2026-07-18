package com.devopsmonitor.backend.service;

import com.devopsmonitor.backend.dto.DashboardSummaryDto;
import com.devopsmonitor.backend.entity.Metric;
import com.devopsmonitor.backend.repository.MetricRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final MetricRepository metricRepository;

    public DashboardService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
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
}