package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_telemetry")
public class SensorTelemetry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private Long sectorId;
    private Double temperature;
    private Double smokeLevel;
    private Double humidity;
    private LocalDateTime recordedAt;

    public SensorTelemetry() {}

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }
    public Long getSectorId() { return sectorId; }
    public void setSectorId(Long sectorId) { this.sectorId = sectorId; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Double getSmokeLevel() { return smokeLevel; }
    public void setSmokeLevel(Double smokeLevel) { this.smokeLevel = smokeLevel; }
    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }
    public LocalDateTime getRecordedAt() { return recordedAt; }

    @PrePersist
    public void setRecordedAtIfMissing() {
        if (recordedAt == null) recordedAt = LocalDateTime.now();
    }
}