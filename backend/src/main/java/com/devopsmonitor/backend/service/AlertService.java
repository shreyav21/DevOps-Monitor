package com.devopsmonitor.backend.service;

import com.devopsmonitor.backend.dto.AlertRequestDto;
import com.devopsmonitor.backend.dto.AlertResponseDto;
import com.devopsmonitor.backend.entity.Alert;
import com.devopsmonitor.backend.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public AlertResponseDto saveAlert(AlertRequestDto request) {

        Alert alert = new Alert();

        alert.setTitle(request.getTitle());
        alert.setMessage(request.getMessage());
        alert.setSeverity(request.getSeverity());
        alert.setSource(request.getSource());
        alert.setStatus(request.getStatus());

        Alert savedAlert = alertRepository.save(alert);

        return mapToResponse(savedAlert);
    }

    public List<AlertResponseDto> getAllAlerts() {

        return alertRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private AlertResponseDto mapToResponse(Alert alert) {

        AlertResponseDto response = new AlertResponseDto();

        response.setId(alert.getId());
        response.setTitle(alert.getTitle());
        response.setMessage(alert.getMessage());
        response.setSeverity(alert.getSeverity());
        response.setSource(alert.getSource());
        response.setStatus(alert.getStatus());
        response.setCreatedAt(alert.getCreatedAt());

        return response;
    }
}