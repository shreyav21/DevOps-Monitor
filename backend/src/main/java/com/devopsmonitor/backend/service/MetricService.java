package com.devopsmonitor.backend.service;

import com.devopsmonitor.backend.dto.MetricRequestDto;
import com.devopsmonitor.backend.dto.MetricResponseDto;
import com.devopsmonitor.backend.entity.Metric;
import com.devopsmonitor.backend.repository.MetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricService {

    private final MetricRepository metricRepository;

    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    public MetricResponseDto saveMetric(MetricRequestDto request) {

        Metric metric = new Metric();

        metric.setCpuUsage(request.getCpuUsage());
        metric.setMemoryUsage(request.getMemoryUsage());
        metric.setDiskUsage(request.getDiskUsage());
        metric.setNetworkUsage(request.getNetworkUsage());

        Metric savedMetric = metricRepository.save(metric);

        return mapToResponse(savedMetric);
    }

    public List<MetricResponseDto> getAllMetrics() {

        return metricRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private MetricResponseDto mapToResponse(Metric metric) {

        MetricResponseDto response = new MetricResponseDto();

        response.setId(metric.getId());
        response.setCpuUsage(metric.getCpuUsage());
        response.setMemoryUsage(metric.getMemoryUsage());
        response.setDiskUsage(metric.getDiskUsage());
        response.setNetworkUsage(metric.getNetworkUsage());
        response.setCreatedAt(metric.getCreatedAt());

        return response;
    }
}