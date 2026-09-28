package com.forestfire.platform.service;

import com.forestfire.platform.entity.VendorBill;
import com.forestfire.platform.repository.VendorBillRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorBillService {
    private final VendorBillRepository repository;
    public VendorBillService(VendorBillRepository repository) { this.repository = repository; }
    public VendorBill create(VendorBill item) { return repository.save(item); }
    public List<VendorBill> getAll() { return repository.findAll(); }
    public VendorBill getById(Long id) { return repository.findById(id).orElse(null); }
}
