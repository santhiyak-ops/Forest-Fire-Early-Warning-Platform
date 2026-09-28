package com.forestfire.platform.controller;

import com.forestfire.platform.entity.JournalEntry;
import com.forestfire.platform.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/journal-entries")
public class JournalEntryController {
    private final JournalEntryService service;
    public JournalEntryController(JournalEntryService service) { this.service = service; }

    @PostMapping
    public JournalEntry create(@RequestBody JournalEntry item) { return service.create(item); }

    @GetMapping
    public List<JournalEntry> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public JournalEntry getById(@PathVariable Long id) { return service.getById(id); }
}
