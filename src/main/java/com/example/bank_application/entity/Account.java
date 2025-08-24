package com.example.bank_application.entity;

import jakarta.persistence.*;
import com.example.bank_application.entity.enums.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author oracle
 **/

@Entity
@Table(name = "accounts")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "account_number", unique = true, nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Version
    private Integer version;

    public Account(User user, String accountNumber, BigDecimal balance, AccountType accountType, String status, LocalDateTime createdAt, Integer version) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
        this.createdAt = createdAt;
        this.version = version;
    }

    // Constructors
    public Account() {
    }
}
