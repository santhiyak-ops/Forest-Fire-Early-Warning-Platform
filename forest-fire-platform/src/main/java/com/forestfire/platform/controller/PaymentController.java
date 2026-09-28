package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Payment;
import com.forestfire.platform.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/payments")
public class PaymentController {
    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }

    @PostMapping
    public Payment create(@RequestBody Payment item) { return service.create(item); }

    @GetMapping
    public List<Payment> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) { return service.getById(id); }
}
