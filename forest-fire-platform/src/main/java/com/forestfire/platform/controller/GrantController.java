package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Grant;
import com.forestfire.platform.service.GrantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/grants")
public class GrantController {
    private final GrantService service;
    public GrantController(GrantService service) { this.service = service; }

    @PostMapping
    public Grant create(@RequestBody Grant item) { return service.create(item); }

    @GetMapping
    public List<Grant> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Grant getById(@PathVariable Long id) { return service.getById(id); }
}
