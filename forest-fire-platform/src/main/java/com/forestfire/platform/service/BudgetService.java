package com.forestfire.platform.service;

import com.forestfire.platform.entity.Budget;
import com.forestfire.platform.repository.BudgetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository repository;
    public BudgetService(BudgetRepository repository) { this.repository = repository; }
    public Budget create(Budget item) { return repository.save(item); }
    public List<Budget> getAll() { return repository.findAll(); }
    public Budget getById(Long id) { return repository.findById(id).orElse(null); }
}
