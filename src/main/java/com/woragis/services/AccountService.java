package com.woragis.services;

import java.util.UUID;

import com.woragis.models.Account;
import com.woragis.models.User;
import com.woragis.repositories.AccountRepository;

public class AccountService {
    private final AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account createAccountForUser(User user) {
        Account account = new Account(user.getId(), generateAccountNumber());
        accountRepo.save(account);
        return account;
    }

    public double viewBalance(UUID userId) {
        var accountOpt = accountRepo.findByUserId(userId);
        return accountOpt.map(Account::getBalance).orElse(-1.0); // or throw exception
    }

    private String generateAccountNumber() {
        return "ACC" + (int) (Math.random() * 100_000); // Simple example
    }
}
