package com.devopsmonitor.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class AlertRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotBlank
    private String severity;

    @NotBlank
    private String source;

    @NotBlank
    private String status;

    public AlertRequestDto() {
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}