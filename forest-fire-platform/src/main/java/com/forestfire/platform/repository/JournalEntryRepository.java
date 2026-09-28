package com.forestfire.platform.repository;

import com.forestfire.platform.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
}
