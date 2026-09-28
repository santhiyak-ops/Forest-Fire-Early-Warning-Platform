package com.forestfire.platform.controller;

import com.forestfire.platform.entity.ForestSector;
import com.forestfire.platform.service.ForestSectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/sectors")
public class ForestSectorController {
    private final ForestSectorService service;
    public ForestSectorController(ForestSectorService service) { this.service = service; }

    @PostMapping public ForestSector create(@RequestBody ForestSector sector) { return service.create(sector); }
    @GetMapping public List<ForestSector> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ForestSector> getById(@PathVariable Long id) {
        ForestSector s = service.getById(id);
        return s == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForestSector> update(@PathVariable Long id, @RequestBody ForestSector sector) {
        ForestSector s = service.update(id, sector);
        return s == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
