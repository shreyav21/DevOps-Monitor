package com.devopsmonitor.backend.repository;

import com.devopsmonitor.backend.entity.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceStatusRepository extends JpaRepository<ServiceStatus, Long> {

}