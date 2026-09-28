package com.forestfire.platform.service;

import com.forestfire.platform.entity.RangerTeam;
import com.forestfire.platform.repository.RangerTeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RangerTeamService {
    private final RangerTeamRepository repository;
    public RangerTeamService(RangerTeamRepository repository) { this.repository = repository; }
    public RangerTeam create(RangerTeam team) { return repository.save(team); }
    public List<RangerTeam> getAll() { return repository.findAll(); }
}
