package com.forestfire.platform.service;


import com.forestfire.platform.repository.*;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ReportService {
    private final ForestSectorRepository sectorRepository;
    private final BudgetRepository budgetRepository;
    private final GrantRepository grantRepository;
    private final PaymentRepository paymentRepository;

    public ReportService(ForestSectorRepository sectorRepository,
                         BudgetRepository budgetRepository,
                         GrantRepository grantRepository,
                         PaymentRepository paymentRepository) {
        this.sectorRepository = sectorRepository;
        this.budgetRepository = budgetRepository;
        this.grantRepository = grantRepository;
        this.paymentRepository = paymentRepository;
    }

    public Map<String, Object> sectorBudgetReport() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("sectors", sectorRepository.findAll());
        result.put("budgets", budgetRepository.findAll());
        return result;
    }

    public Map<String, Object> conservationProfitLoss() {
        double grants = grantRepository.findAll().stream()
                .mapToDouble(g -> g.getAmount() == null ? 0 : g.getAmount()).sum();
        double payments = paymentRepository.findAll().stream()
                .mapToDouble(p -> p.getAmount() == null ? 0 : p.getAmount()).sum();

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("grantIncome", grants);
        result.put("emergencyPayments", payments);
        result.put("netBalance", grants - payments);
        return result;
    }

    public Map<String, Object> balanceSheet() {
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("forestrySectors", sectorRepository.count());
        result.put("budgets", budgetRepository.findAll());
        result.put("note", "Detailed asset/liability balances can be extended from JournalEntry records.");
        return result;
    }
}
