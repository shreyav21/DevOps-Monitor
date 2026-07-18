package com.devopsmonitor.backend.controller;

import com.devopsmonitor.backend.dto.DashboardSummaryDto;
import com.devopsmonitor.backend.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public DashboardSummaryDto getSummary() {
        return dashboardService.getDashboardSummary();
    }
}