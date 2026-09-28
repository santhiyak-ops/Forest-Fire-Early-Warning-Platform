package com.forestfire.platform.service;

import com.forestfire.platform.entity.JournalEntry;
import com.forestfire.platform.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JournalEntryService {
    private final JournalEntryRepository repository;
    public JournalEntryService(JournalEntryRepository repository) { this.repository = repository; }
    public JournalEntry create(JournalEntry item) { return repository.save(item); }
    public List<JournalEntry> getAll() { return repository.findAll(); }
    public JournalEntry getById(Long id) { return repository.findById(id).orElse(null); }
}
