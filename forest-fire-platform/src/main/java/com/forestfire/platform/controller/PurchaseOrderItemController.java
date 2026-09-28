package com.forestfire.platform.controller;

import com.forestfire.platform.entity.PurchaseOrderItem;
import com.forestfire.platform.service.PurchaseOrderItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/purchase-order-items")
public class PurchaseOrderItemController {
    private final PurchaseOrderItemService service;
    public PurchaseOrderItemController(PurchaseOrderItemService service) { this.service = service; }

    @PostMapping
    public PurchaseOrderItem create(@RequestBody PurchaseOrderItem item) { return service.create(item); }

    @GetMapping
    public List<PurchaseOrderItem> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public PurchaseOrderItem getById(@PathVariable Long id) { return service.getById(id); }
}
