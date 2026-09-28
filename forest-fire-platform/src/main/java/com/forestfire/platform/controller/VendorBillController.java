package com.forestfire.platform.controller;

import com.forestfire.platform.entity.VendorBill;
import com.forestfire.platform.service.VendorBillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/vendor-bills")
public class VendorBillController {
    private final VendorBillService service;
    public VendorBillController(VendorBillService service) { this.service = service; }

    @PostMapping
    public VendorBill create(@RequestBody VendorBill item) { return service.create(item); }

    @GetMapping
    public List<VendorBill> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public VendorBill getById(@PathVariable Long id) { return service.getById(id); }
}
