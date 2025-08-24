package com.example.bank_application.entity;

import jakarta.persistence.*;
import com.example.bank_application.entity.enums.CardStatus;
import com.example.bank_application.entity.enums.CardType;

import java.time.LocalDate;


/**
 * @author oracle
 **/

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false, unique = true, length = 16)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType cardType;

    @Column(nullable = false, length = 4)
    private String cvv;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;

    public Card(){}

    public Card(User user, Account account, String cardNumber, CardType cardType, String cvv, LocalDate expiryDate, CardStatus status) {
        this.user = user;
        this.account = account;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", user=" + user +
                ", account=" + account +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType=" + cardType +
                ", cvv='" + cvv + '\'' +
                ", expiryDate=" + expiryDate +
                ", status=" + status +
                '}';
    }

    // Getters and Setters
}

