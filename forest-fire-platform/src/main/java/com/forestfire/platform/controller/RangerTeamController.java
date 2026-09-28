package com.forestfire.platform.controller;

import com.forestfire.platform.entity.RangerTeam;
import com.forestfire.platform.service.RangerTeamService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/rangers")
public class RangerTeamController {
    private final RangerTeamService service;
    public RangerTeamController(RangerTeamService service) { this.service = service; }

    @PostMapping public RangerTeam create(@RequestBody RangerTeam team) { return service.create(team); }
    @GetMapping public List<RangerTeam> getAll() { return service.getAll(); }
}
