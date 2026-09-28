package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_bills")
public class VendorBill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long purchaseOrderId;
    private Long vendorId;
    private String billNumber;
    private LocalDateTime billDate;
    private Double amount;
    private String status;

    public VendorBill() {}

    @PrePersist
    public void setDefaults() {
        if (billDate == null) billDate = LocalDateTime.now();
        if (status == null) status = "UNPAID";
    }

    public Long getId() { return id; }
    public Long getPurchaseOrderId() { return purchaseOrderId; }
    public void setPurchaseOrderId(Long purchaseOrderId) { this.purchaseOrderId = purchaseOrderId; }
    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }
    public String getBillNumber() { return billNumber; }
    public void setBillNumber(String billNumber) { this.billNumber = billNumber; }
    public LocalDateTime getBillDate() { return billDate; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
