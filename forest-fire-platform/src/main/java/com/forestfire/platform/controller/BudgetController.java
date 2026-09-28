package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Budget;
import com.forestfire.platform.service.BudgetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/budgets")
public class BudgetController {
    private final BudgetService service;
    public BudgetController(BudgetService service) { this.service = service; }

    @PostMapping
    public Budget create(@RequestBody Budget item) { return service.create(item); }

    @GetMapping
    public List<Budget> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Budget getById(@PathVariable Long id) { return service.getById(id); }
}
