package com.devopsmonitor.backend.service;

import com.devopsmonitor.backend.dto.ServiceStatusRequestDto;
import com.devopsmonitor.backend.dto.ServiceStatusResponseDto;
import com.devopsmonitor.backend.entity.ServiceStatus;
import com.devopsmonitor.backend.repository.ServiceStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStatusService {

    private final ServiceStatusRepository repository;

    public ServiceStatusService(ServiceStatusRepository repository) {
        this.repository = repository;
    }

    public ServiceStatusResponseDto saveService(ServiceStatusRequestDto request) {

        ServiceStatus service = new ServiceStatus();

        service.setName(request.getName());
        service.setStatus(request.getStatus());
        service.setCpuUsage(request.getCpuUsage());
        service.setMemoryUsage(request.getMemoryUsage());
        service.setUptime(request.getUptime());

        ServiceStatus saved = repository.save(service);

        return mapToResponse(saved);
    }

    public List<ServiceStatusResponseDto> getAllServices() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ServiceStatusResponseDto mapToResponse(ServiceStatus service) {

        ServiceStatusResponseDto response = new ServiceStatusResponseDto();

        response.setId(service.getId());
        response.setName(service.getName());
        response.setStatus(service.getStatus());
        response.setCpuUsage(service.getCpuUsage());
        response.setMemoryUsage(service.getMemoryUsage());
        response.setUptime(service.getUptime());
        response.setLastUpdated(service.getLastUpdated());

        return response;
    }
}