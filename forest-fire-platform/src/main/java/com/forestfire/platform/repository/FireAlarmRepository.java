package com.forestfire.platform.repository;

import com.forestfire.platform.entity.FireAlarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FireAlarmRepository extends JpaRepository<FireAlarm, Long> {
    List<FireAlarm> findByStatus(String status);
}
