package com.devopsmonitor.backend.config;

import com.devopsmonitor.backend.entity.Alert;
import com.devopsmonitor.backend.entity.Metric;
import com.devopsmonitor.backend.entity.ServiceStatus;
import com.devopsmonitor.backend.repository.AlertRepository;
import com.devopsmonitor.backend.repository.MetricRepository;
import com.devopsmonitor.backend.repository.ServiceStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(
            MetricRepository metricRepository,
            ServiceStatusRepository serviceRepository,
            AlertRepository alertRepository) {

        return args -> {

            // Seed only when the database is empty
            if (metricRepository.count() == 0) {

                Metric metric1 = new Metric();
                metric1.setCpuUsage(32.5);
                metric1.setMemoryUsage(48.2);
                metric1.setDiskUsage(41.7);
                metric1.setNetworkUsage(25.4);

                Metric metric2 = new Metric();
                metric2.setCpuUsage(45.8);
                metric2.setMemoryUsage(52.6);
                metric2.setDiskUsage(43.1);
                metric2.setNetworkUsage(31.8);

                Metric metric3 = new Metric();
                metric3.setCpuUsage(58.3);
                metric3.setMemoryUsage(61.4);
                metric3.setDiskUsage(45.6);
                metric3.setNetworkUsage(38.7);

                Metric metric4 = new Metric();
                metric4.setCpuUsage(42.1);
                metric4.setMemoryUsage(55.3);
                metric4.setDiskUsage(47.2);
                metric4.setNetworkUsage(29.5);

                Metric metric5 = new Metric();
                metric5.setCpuUsage(36.7);
                metric5.setMemoryUsage(49.8);
                metric5.setDiskUsage(48.9);
                metric5.setNetworkUsage(27.3);

                metricRepository.save(metric1);
                metricRepository.save(metric2);
                metricRepository.save(metric3);
                metricRepository.save(metric4);
                metricRepository.save(metric5);
            }

            if (serviceRepository.count() == 0) {

                ServiceStatus backend = new ServiceStatus();
                backend.setName("Backend API");
                backend.setStatus("UP");
                backend.setCpuUsage(32.5);
                backend.setMemoryUsage(48.2);
                backend.setUptime(99.98);

                ServiceStatus database = new ServiceStatus();
                database.setName("PostgreSQL");
                database.setStatus("UP");
                database.setCpuUsage(18.4);
                database.setMemoryUsage(42.7);
                database.setUptime(99.99);

                ServiceStatus frontend = new ServiceStatus();
                frontend.setName("Frontend");
                frontend.setStatus("UP");
                frontend.setCpuUsage(24.6);
                frontend.setMemoryUsage(38.5);
                frontend.setUptime(99.95);

                ServiceStatus redis = new ServiceStatus();
                redis.setName("Redis");
                redis.setStatus("UP");
                redis.setCpuUsage(12.8);
                redis.setMemoryUsage(31.4);
                redis.setUptime(99.97);

                serviceRepository.save(backend);
                serviceRepository.save(database);
                serviceRepository.save(frontend);
                serviceRepository.save(redis);
            }

            if (alertRepository.count() == 0) {

                Alert alert1 = new Alert();
                alert1.setTitle("High CPU Usage");
                alert1.setMessage("CPU usage exceeded 80%.");
                alert1.setSeverity("WARNING");
                alert1.setSource("Backend API");
                alert1.setStatus("ACTIVE");

                Alert alert2 = new Alert();
                alert2.setTitle("Memory Usage Increased");
                alert2.setMessage("Memory usage is above normal levels.");
                alert2.setSeverity("INFO");
                alert2.setSource("PostgreSQL");
                alert2.setStatus("RESOLVED");

                alertRepository.save(alert1);
                alertRepository.save(alert2);
            }

            System.out.println("=================================");
            System.out.println("DevOps Monitor sample data seeded!");
            System.out.println("=================================");
        };
    }
}