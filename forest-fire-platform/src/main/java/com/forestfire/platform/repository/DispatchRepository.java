package com.forestfire.platform.repository;

import com.forestfire.platform.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
}
