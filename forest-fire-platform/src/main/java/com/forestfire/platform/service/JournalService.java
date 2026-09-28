package com.forestfire.platform.service;

import com.forestfire.platform.entity.Journal;
import com.forestfire.platform.repository.JournalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JournalService {
    private final JournalRepository repository;
    public JournalService(JournalRepository repository) { this.repository = repository; }
    public Journal create(Journal item) { return repository.save(item); }
    public List<Journal> getAll() { return repository.findAll(); }
    public Journal getById(Long id) { return repository.findById(id).orElse(null); }
}
