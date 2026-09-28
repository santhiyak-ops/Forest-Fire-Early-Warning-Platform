package com.forestfire.platform.service;

import com.forestfire.platform.entity.FireAlarm;
import com.forestfire.platform.repository.FireAlarmRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FireAlarmService {
    private final FireAlarmRepository repository;
    public FireAlarmService(FireAlarmRepository repository) { this.repository = repository; }

    public List<FireAlarm> getAll() { return repository.findAll(); }
    public List<FireAlarm> getActive() { return repository.findByStatus("ACTIVE"); }

    public FireAlarm resolve(Long id) {
        FireAlarm alarm = repository.findById(id).orElse(null);
        if (alarm == null) return null;
        alarm.setStatus("RESOLVED");
        alarm.setResolvedAt(LocalDateTime.now());
        return repository.save(alarm);
    }
}
