package com.forestfire.platform.controller;

import com.forestfire.platform.entity.PurchaseOrder;
import com.forestfire.platform.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/purchase-orders")
public class PurchaseOrderController {
    private final PurchaseOrderService service;
    public PurchaseOrderController(PurchaseOrderService service) { this.service = service; }

    @PostMapping
    public PurchaseOrder create(@RequestBody PurchaseOrder item) { return service.create(item); }

    @GetMapping
    public List<PurchaseOrder> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public PurchaseOrder getById(@PathVariable Long id) { return service.getById(id); }
}
