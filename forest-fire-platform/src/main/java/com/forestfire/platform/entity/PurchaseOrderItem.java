package com.forestfire.platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_order_items")
public class PurchaseOrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long purchaseOrderId;
    private Long productId;
    private Integer quantity;
    private Double unitPrice;
    private Double subtotal;

    public PurchaseOrderItem() {}

    @PrePersist @PreUpdate
    public void calculateSubtotal() {
        if (quantity != null && unitPrice != null) subtotal = quantity * unitPrice;
    }

    public Long getId() { return id; }
    public Long getPurchaseOrderId() { return purchaseOrderId; }
    public void setPurchaseOrderId(Long purchaseOrderId) { this.purchaseOrderId = purchaseOrderId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
    public Double getSubtotal() { return subtotal; }
}
