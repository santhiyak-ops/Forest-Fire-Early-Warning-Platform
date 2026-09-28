package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "grants")
public class Grant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grantName;
    private String grantSource;
    private Double amount;
    private LocalDateTime grantDate;
    private Long sectorId;
    private String status;

    public Grant() {}

    @PrePersist
    public void setDefaults() {
        if (grantDate == null) grantDate = LocalDateTime.now();
        if (status == null) status = "RECEIVED";
    }

    public Long getId() { return id; }
    public String getGrantName() { return grantName; }
    public void setGrantName(String grantName) { this.grantName = grantName; }
    public String getGrantSource() { return grantSource; }
    public void setGrantSource(String grantSource) { this.grantSource = grantSource; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public LocalDateTime getGrantDate() { return grantDate; }
    public Long getSectorId() { return sectorId; }
    public void setSectorId(Long sectorId) { this.sectorId = sectorId; }
    public String getStatus() { return status; }
}
