package com.forestfire.platform.service;

import com.forestfire.platform.entity.PurchaseOrder;
import com.forestfire.platform.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    public PurchaseOrderService(PurchaseOrderRepository repository) { this.repository = repository; }
    public PurchaseOrder create(PurchaseOrder item) { return repository.save(item); }
    public List<PurchaseOrder> getAll() { return repository.findAll(); }
    public PurchaseOrder getById(Long id) { return repository.findById(id).orElse(null); }
}
