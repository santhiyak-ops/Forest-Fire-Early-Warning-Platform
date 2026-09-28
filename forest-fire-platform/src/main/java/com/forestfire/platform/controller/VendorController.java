package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Vendor;
import com.forestfire.platform.service.VendorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/vendors")
public class VendorController {
    private final VendorService service;
    public VendorController(VendorService service) { this.service = service; }

    @PostMapping
    public Vendor create(@RequestBody Vendor item) { return service.create(item); }

    @GetMapping
    public List<Vendor> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Vendor getById(@PathVariable Long id) { return service.getById(id); }
}
