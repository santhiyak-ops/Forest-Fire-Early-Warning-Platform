package com.forestfire.platform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chart_of_accounts")
public class ChartOfAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountCode;
    private String accountName;
    private String accountType;

    public ChartOfAccount() {}

    public Long getId() { return id; }
    public String getAccountCode() { return accountCode; }
    public void setAccountCode(String accountCode) { this.accountCode = accountCode; }
    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
}
