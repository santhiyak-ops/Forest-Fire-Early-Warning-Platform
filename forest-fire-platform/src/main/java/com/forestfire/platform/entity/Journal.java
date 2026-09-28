package com.forestfire.platform.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "journals")
public class Journal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String journalName;
    private LocalDateTime journalDate;

    public Journal() {}

    @PrePersist
    public void setDate() {
        if (journalDate == null) journalDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getJournalName() { return journalName; }
    public void setJournalName(String journalName) { this.journalName = journalName; }
    public LocalDateTime getJournalDate() { return journalDate; }
}
