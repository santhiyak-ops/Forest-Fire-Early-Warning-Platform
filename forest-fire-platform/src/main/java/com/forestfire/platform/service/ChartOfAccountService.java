package com.forestfire.platform.service;

import com.forestfire.platform.entity.ChartOfAccount;
import com.forestfire.platform.repository.ChartOfAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChartOfAccountService {
    private final ChartOfAccountRepository repository;
    public ChartOfAccountService(ChartOfAccountRepository repository) { this.repository = repository; }
    public ChartOfAccount create(ChartOfAccount item) { return repository.save(item); }
    public List<ChartOfAccount> getAll() { return repository.findAll(); }
    public ChartOfAccount getById(Long id) { return repository.findById(id).orElse(null); }
}
