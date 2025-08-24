package com.example.bank_application.entity;

import jakarta.persistence.*;
import com.example.bank_application.entity.enums.TransactionStatus;
import com.example.bank_application.entity.enums.TransactionType;


import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author oracle
 **/

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txnId;

    @ManyToOne
    @JoinColumn(name = "from_accountId", nullable = false)
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_accountId", nullable = false)
    private Account toAccount;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;




    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(length = 500)
    private String message;

    public Transaction(Long txnId, Account fromAccount, Account toAccount, Card card, BigDecimal amount, LocalDateTime timestamp, TransactionType type, TransactionStatus status, String message) {
        this.txnId = txnId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.card = card;
        this.amount = amount;
        this.timestamp = timestamp;
        this.type = type;
        this.status = status;
        this.message = message;
    }

    public Transaction(){}

    @Override
    public String toString() {
        return "Transaction{" +
                "txnId=" + txnId +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", card=" + card +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", type=" + type +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
