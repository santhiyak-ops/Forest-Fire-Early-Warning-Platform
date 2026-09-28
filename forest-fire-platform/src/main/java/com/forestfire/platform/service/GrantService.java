package com.forestfire.platform.service;

import com.forestfire.platform.entity.Grant;
import com.forestfire.platform.repository.GrantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrantService {
    private final GrantRepository repository;
    public GrantService(GrantRepository repository) { this.repository = repository; }
    public Grant create(Grant item) { return repository.save(item); }
    public List<Grant> getAll() { return repository.findAll(); }
    public Grant getById(Long id) { return repository.findById(id).orElse(null); }
}
