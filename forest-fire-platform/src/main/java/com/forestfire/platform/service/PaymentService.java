package com.forestfire.platform.service;

import com.forestfire.platform.entity.Payment;
import com.forestfire.platform.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    public PaymentService(PaymentRepository repository) { this.repository = repository; }
    public Payment create(Payment item) { return repository.save(item); }
    public List<Payment> getAll() { return repository.findAll(); }
    public Payment getById(Long id) { return repository.findById(id).orElse(null); }
}
