package com.forestfire.platform.repository;

import com.forestfire.platform.entity.Grant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GrantRepository extends JpaRepository<Grant, Long> {
}
