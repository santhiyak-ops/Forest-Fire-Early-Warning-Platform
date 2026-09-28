package com.forestfire.platform.service;

import com.forestfire.platform.entity.Dispatch;
import com.forestfire.platform.repository.DispatchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispatchService {
    private final DispatchRepository repository;
    public DispatchService(DispatchRepository repository) { this.repository = repository; }
    public Dispatch create(Dispatch dispatch) { return repository.save(dispatch); }
    public List<Dispatch> getAll() { return repository.findAll(); }
    public Dispatch updateStatus(Long id, String status) {
        Dispatch d = repository.findById(id).orElse(null);
        if (d == null) return null;
        d.setStatus(status);
        return repository.save(d);
    }
}
