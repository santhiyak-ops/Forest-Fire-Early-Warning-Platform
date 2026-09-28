package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vendorBillId;
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentMethod;
    private String status;

    public Payment() {}

    @PrePersist
    public void setDefaults() {
        if (paymentDate == null) paymentDate = LocalDateTime.now();
        if (status == null) status = "PAID";
    }

    public Long getId() { return id; }
    public Long getVendorBillId() { return vendorBillId; }
    public void setVendorBillId(Long vendorBillId) { this.vendorBillId = vendorBillId; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getStatus() { return status; }
}
