package com.forestfire.platform.repository;

import com.forestfire.platform.entity.SensorTelemetry;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorTelemetryRepository extends JpaRepository<SensorTelemetry, Long> {
}
