package com.forestfire.platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "forest_sectors")
public class ForestSector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sectorName;
    private String location;
    private String riskLevel;
    private Double annualBudget;

    public ForestSector() {}
    public Long getId() { return id; }
    public String getSectorName() { return sectorName; }
    public void setSectorName(String sectorName) { this.sectorName = sectorName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public Double getAnnualBudget() { return annualBudget; }
    public void setAnnualBudget(Double annualBudget) { this.annualBudget = annualBudget; }
}
