package com.forestfire.platform.controller;

import com.forestfire.platform.service.ReportService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService service;
    public ReportController(ReportService service) { this.service = service; }

    @GetMapping("/sector-budget")
    public Map<String, Object> sectorBudget() { return service.sectorBudgetReport(); }

    @GetMapping("/profit-loss")
    public Map<String, Object> profitLoss() { return service.conservationProfitLoss(); }

    @GetMapping("/balance-sheet")
    public Map<String, Object> balanceSheet() { return service.balanceSheet(); }
}
