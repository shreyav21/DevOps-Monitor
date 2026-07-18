package com.devopsmonitor.backend.controller;

import com.devopsmonitor.backend.dto.AlertRequestDto;
import com.devopsmonitor.backend.dto.AlertResponseDto;
import com.devopsmonitor.backend.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public List<AlertResponseDto> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @PostMapping
    public AlertResponseDto saveAlert(
            @Valid @RequestBody AlertRequestDto request) {

        return alertService.saveAlert(request);
    }
}