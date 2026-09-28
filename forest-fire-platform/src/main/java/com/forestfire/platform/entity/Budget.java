package com.forestfire.platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sectorId;
    private String financialYear;
    private Double allocatedAmount;
    private Double spentAmount;
    private Double remainingAmount;

    public Budget() {}

    @PrePersist @PreUpdate
    public void calculateRemaining() {
        if (allocatedAmount == null) allocatedAmount = 0.0;
        if (spentAmount == null) spentAmount = 0.0;
        remainingAmount = allocatedAmount - spentAmount;
    }

    public Long getId() { return id; }
    public Long getSectorId() { return sectorId; }
    public void setSectorId(Long sectorId) { this.sectorId = sectorId; }
    public String getFinancialYear() { return financialYear; }
    public void setFinancialYear(String financialYear) { this.financialYear = financialYear; }
    public Double getAllocatedAmount() { return allocatedAmount; }
    public void setAllocatedAmount(Double allocatedAmount) { this.allocatedAmount = allocatedAmount; }
    public Double getSpentAmount() { return spentAmount; }
    public void setSpentAmount(Double spentAmount) { this.spentAmount = spentAmount; }
    public Double getRemainingAmount() { return remainingAmount; }
}
