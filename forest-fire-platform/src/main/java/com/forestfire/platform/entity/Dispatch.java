package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dispatches")
public class Dispatch {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long alarmId;
    private Long sectorId;
    private Long rangerTeamId;
    private LocalDateTime dispatchTime;
    private String status;
    private String vehicleNumber;
    private Double fuelCost;
    private Double supplyCost;
    private String remarks;

    public Dispatch() {}

    @PrePersist
    public void setDefaults() {
        if (dispatchTime == null) dispatchTime = LocalDateTime.now();
        if (status == null) status = "DISPATCHED";
        if (fuelCost == null) fuelCost = 0.0;
        if (supplyCost == null) supplyCost = 0.0;
    }

    public Long getId() { return id; }
    public Long getAlarmId() { return alarmId; }
    public void setAlarmId(Long alarmId) { this.alarmId = alarmId; }
    public Long getSectorId() { return sectorId; }
    public void setSectorId(Long sectorId) { this.sectorId = sectorId; }
    public Long getRangerTeamId() { return rangerTeamId; }
    public void setRangerTeamId(Long rangerTeamId) { this.rangerTeamId = rangerTeamId; }
    public LocalDateTime getDispatchTime() { return dispatchTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public Double getFuelCost() { return fuelCost; }
    public void setFuelCost(Double fuelCost) { this.fuelCost = fuelCost; }
    public Double getSupplyCost() { return supplyCost; }
    public void setSupplyCost(Double supplyCost) { this.supplyCost = supplyCost; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
