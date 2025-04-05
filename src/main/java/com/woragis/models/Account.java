package com.woragis.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String accountNumber;
    private final UUID ownerId;
    private double balance;
    private final List<Transaction> transactions;

    public Account(UUID ownerId, String accountNumber) {
        this.id = UUID.randomUUID();
        this.ownerId = ownerId;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Balance operations
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive.");
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount, "Deposit to account", null, this.accountNumber));
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Invalid amount.");
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount, "Withdraw from account", this.accountNumber, null));
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }
}
