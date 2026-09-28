package com.forestfire.platform.controller;

import com.forestfire.platform.entity.ChartOfAccount;
import com.forestfire.platform.service.ChartOfAccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/chart-of-accounts")
public class ChartOfAccountController {
    private final ChartOfAccountService service;
    public ChartOfAccountController(ChartOfAccountService service) { this.service = service; }

    @PostMapping
    public ChartOfAccount create(@RequestBody ChartOfAccount item) { return service.create(item); }

    @GetMapping
    public List<ChartOfAccount> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ChartOfAccount getById(@PathVariable Long id) { return service.getById(id); }
}
