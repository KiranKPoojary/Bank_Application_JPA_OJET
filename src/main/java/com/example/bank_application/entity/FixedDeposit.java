package com.example.bank_application.entity;

import jakarta.persistence.*;
import com.example.bank_application.entity.enums.FDStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author oracle
 **/
@Entity
@Table(name = "fixed_deposits")
public class FixedDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fdId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal principalAmount;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate maturityDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FDStatus status;

    public FixedDeposit(User user, BigDecimal principalAmount, LocalDate startDate, Double interestRate, LocalDate maturityDate, FDStatus status) {
        this.user = user;
        this.principalAmount = principalAmount;
        this.startDate = startDate;
        this.interestRate = interestRate;
        this.maturityDate = maturityDate;
        this.status = status;
    }

    public FixedDeposit(){}

    @Override
    public String toString() {
        return "FixedDeposit{" +
                "fdId=" + fdId +
                ", user=" + user +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", startDate=" + startDate +
                ", maturityDate=" + maturityDate +
                ", status=" + status +
                '}';
    }

    // Getters and Setters
}