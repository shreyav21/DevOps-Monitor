package com.devopsmonitor.backend.controller;

import com.devopsmonitor.backend.dto.MetricRequestDto;
import com.devopsmonitor.backend.dto.MetricResponseDto;
import com.devopsmonitor.backend.service.MetricService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping
    public List<MetricResponseDto> getAllMetrics() {
        return metricService.getAllMetrics();
    }

    @PostMapping
    public MetricResponseDto saveMetric(@Valid @RequestBody MetricRequestDto request) {
        return metricService.saveMetric(request);
    }
}