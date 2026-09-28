package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vendorId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;

    public PurchaseOrder() {}

    @PrePersist
    public void setDefaults() {
        if (orderDate == null) orderDate = LocalDateTime.now();
        if (status == null) status = "CREATED";
        if (totalAmount == null) totalAmount = 0.0;
    }

    public Long getId() { return id; }
    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
