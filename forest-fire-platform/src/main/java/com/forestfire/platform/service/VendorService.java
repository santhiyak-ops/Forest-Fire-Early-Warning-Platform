package com.forestfire.platform.service;

import com.forestfire.platform.entity.Vendor;
import com.forestfire.platform.repository.VendorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorService {
    private final VendorRepository repository;
    public VendorService(VendorRepository repository) { this.repository = repository; }
    public Vendor create(Vendor item) { return repository.save(item); }
    public List<Vendor> getAll() { return repository.findAll(); }
    public Vendor getById(Long id) { return repository.findById(id).orElse(null); }
}
