package com.forestfire.platform.repository;

import com.forestfire.platform.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
