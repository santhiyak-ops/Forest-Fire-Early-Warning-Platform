package com.forestfire.platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TelemetryRequest {
    @NotBlank private String sensorId;
    @NotNull private Long sectorId;
    @NotNull private Double temperature;
    @NotNull private Double smokeLevel;
    private Double humidity;

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
}
