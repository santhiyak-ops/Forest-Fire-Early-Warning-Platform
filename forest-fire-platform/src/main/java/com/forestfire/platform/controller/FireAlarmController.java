package com.forestfire.platform.controller;

import com.forestfire.platform.entity.FireAlarm;
import com.forestfire.platform.service.FireAlarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/alarms")
public class FireAlarmController {
    private final FireAlarmService service;
    public FireAlarmController(FireAlarmService service) { this.service = service; }

    @GetMapping public List<FireAlarm> getAll() { return service.getAll(); }
    @GetMapping("/active") public List<FireAlarm> getActive() { return service.getActive(); }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<FireAlarm> resolve(@PathVariable Long id) {
        FireAlarm alarm = service.resolve(id);
        return alarm == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(alarm);
    }
}
