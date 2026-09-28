package com.forestfire.platform.controller;

import com.forestfire.platform.dto.TelemetryRequest;
import com.forestfire.platform.entity.SensorTelemetry;
import com.forestfire.platform.service.TelemetryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/telemetry")
public class TelemetryController {
    private final TelemetryService service;
    public TelemetryController(TelemetryService service) { this.service = service; }

    @PostMapping
    public SensorTelemetry ingest(@Valid @RequestBody TelemetryRequest request) {
        return service.ingest(request);
    }

    @GetMapping
    public List<SensorTelemetry> getAll() { return service.getAll(); }
}
