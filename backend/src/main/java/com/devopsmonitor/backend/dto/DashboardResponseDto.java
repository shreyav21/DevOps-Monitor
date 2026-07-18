package com.devopsmonitor.backend.dto;

import java.util.List;

public class DashboardResponseDto {

    private DashboardSummaryDto summary;

    private List<DashboardHistoryDto> history;

    private List<ServiceStatusResponseDto> services;

    private List<AlertResponseDto> alerts;

    public DashboardResponseDto() {
    }

    public DashboardSummaryDto getSummary() {
        return summary;
    }

    public void setSummary(DashboardSummaryDto summary) {
        this.summary = summary;
    }

    public List<DashboardHistoryDto> getHistory() {
        return history;
    }

    public void setHistory(List<DashboardHistoryDto> history) {
        this.history = history;
    }

    public List<ServiceStatusResponseDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceStatusResponseDto> services) {
        this.services = services;
    }

    public List<AlertResponseDto> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<AlertResponseDto> alerts) {
        this.alerts = alerts;
    }
}