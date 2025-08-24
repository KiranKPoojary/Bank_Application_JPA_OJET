package com.example.bank_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import com.example.bank_application.entity.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oracle
 **/

@Entity
@Table(name = "users")

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long userId;

        @NotNull
        @Column(name = "first_name")
        private String firstName;

        @NotNull
        @Column(name = "last_name")
        private String lastName;

        @Column(name = "dob")
        private LocalDate dob;

        @Email
        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "phone", unique = true)
        private String phone;

        @Column(name = "kyc_verified")
        private boolean kycVerified;

        @Column(name = "address")
        private String address;

        @Enumerated(EnumType.STRING)
        @Column(name = "role")
        private Role role;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Account> accounts=new ArrayList<>();

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
        private List<Loan> loans = new ArrayList<>();

        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
        private  List<FixedDeposit> fixedDeposits = new ArrayList<>();

        @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
        private List<Card> cards = new ArrayList<>();

        public User() {
            this.createdAt = LocalDateTime.now();
        }

        public User(String fullName, String lastName, LocalDate dob, String email, String phone, boolean kycVerified, String address, Role role) {
            this.firstName = fullName;
            this.lastName= lastName;
            this.dob = dob;
            this.email = email;
            this.phone = phone;
            this.kycVerified = kycVerified;
            this.address = address;
            this.role = role;
            this.createdAt = LocalDateTime.now();
        }

    public void addAccount(Account account) {
        if(account!=null){
            this.accounts.add(account);
        }

    }

    public void addCard(Card card) {
        if(card!=null){
            this.cards.add(card);
        }

    }

    public void addLoan(Loan loan) {
        if(loan!=null){
            this.loans.add(loan);
        }

    }

    public void addFixedDeposit(FixedDeposit FD) {
        if(FD!=null){
            this.fixedDeposits.add(FD);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", kycVerified=" + kycVerified +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}
