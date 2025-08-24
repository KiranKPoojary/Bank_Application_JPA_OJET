package com.example.bank_application.entity;

import jakarta.persistence.*;
import com.example.bank_application.entity.enums.LoanStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author oracle
 **/
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;

    @Column(nullable = false)
    private Integer loanTermMonths;

    @Column(nullable = false)
    private Double interestRate;

    public Loan(User user, BigDecimal amount, LoanStatus status, LocalDateTime createdAt, Employee approvedBy, Integer loanTermMonths, Double interestRate) {
        this.user = user;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.approvedBy = approvedBy;
        this.loanTermMonths = loanTermMonths;
        this.interestRate = interestRate;
    }

    public Loan(){}

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", user=" + user +
                ", amount=" + amount +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", approvedBy=" + approvedBy +
                ", loanTermMonths=" + loanTermMonths +
                ", interestRate=" + interestRate +
                '}';
    }

    // Getters and Setters
}