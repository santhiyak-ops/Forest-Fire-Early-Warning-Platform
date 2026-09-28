package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Journal;
import com.forestfire.platform.service.JournalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/journals")
public class JournalController {
    private final JournalService service;
    public JournalController(JournalService service) { this.service = service; }

    @PostMapping
    public Journal create(@RequestBody Journal item) { return service.create(item); }

    @GetMapping
    public List<Journal> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Journal getById(@PathVariable Long id) { return service.getById(id); }
}
