package com.forestfire.platform.service;

import com.forestfire.platform.entity.ForestSector;
import com.forestfire.platform.repository.ForestSectorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ForestSectorService {
    private final ForestSectorRepository repository;
    public ForestSectorService(ForestSectorRepository repository) { this.repository = repository; }

    public ForestSector create(ForestSector sector) { return repository.save(sector); }
    public List<ForestSector> getAll() { return repository.findAll(); }
    public ForestSector getById(Long id) { return repository.findById(id).orElse(null); }
    public ForestSector update(Long id, ForestSector input) {
        ForestSector s = getById(id);
        if (s == null) return null;
        s.setSectorName(input.getSectorName());
        s.setLocation(input.getLocation());
        s.setRiskLevel(input.getRiskLevel());
        s.setAnnualBudget(input.getAnnualBudget());
        return repository.save(s);
    }
    public void delete(Long id) { repository.deleteById(id); }
}
