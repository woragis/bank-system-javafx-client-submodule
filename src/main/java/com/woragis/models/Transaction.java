package com.woragis.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private final LocalDateTime timestamp;
    private final String type; // DEPOSIT, WITHDRAW, TRANSFER
    private final double amount;
    private final String description;
    private final String fromAccount;
    private final String toAccount;

    public Transaction(String type, double amount, String description, String fromAccount, String toAccount) {
        this.id = UUID.randomUUID();
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }
}
