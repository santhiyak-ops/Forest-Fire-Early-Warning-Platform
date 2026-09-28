package com.forestfire.platform.service;

import com.forestfire.platform.entity.PurchaseOrderItem;
import com.forestfire.platform.repository.PurchaseOrderItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderItemService {
    private final PurchaseOrderItemRepository repository;
    public PurchaseOrderItemService(PurchaseOrderItemRepository repository) { this.repository = repository; }
    public PurchaseOrderItem create(PurchaseOrderItem item) { return repository.save(item); }
    public List<PurchaseOrderItem> getAll() { return repository.findAll(); }
    public PurchaseOrderItem getById(Long id) { return repository.findById(id).orElse(null); }
}
