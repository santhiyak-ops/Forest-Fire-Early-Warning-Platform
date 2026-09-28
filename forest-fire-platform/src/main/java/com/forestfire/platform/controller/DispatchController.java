package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Dispatch;
import com.forestfire.platform.service.DispatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/forest/dispatches")
public class DispatchController {
    private final DispatchService service;
    public DispatchController(DispatchService service) { this.service = service; }

    @PostMapping public Dispatch create(@RequestBody Dispatch dispatch) { return service.create(dispatch); }
    @GetMapping public List<Dispatch> getAll() { return service.getAll(); }

    @PutMapping("/{id}/status")
    public ResponseEntity<Dispatch> updateStatus(@PathVariable Long id,
                                                  @RequestBody Map<String, String> body) {
        Dispatch d = service.updateStatus(id, body.get("status"));
        return d == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }
}
