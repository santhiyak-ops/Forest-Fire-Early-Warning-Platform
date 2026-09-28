package com.forestfire.platform.repository;

import com.forestfire.platform.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
