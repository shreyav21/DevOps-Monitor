package com.devopsmonitor.backend.repository;

import com.devopsmonitor.backend.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
    Optional<Metric> findTopByOrderByCreatedAtDesc();
}