package com.woragis.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.woragis.models.Account;

public class AccountRepository {
    private final Map<UUID, Account> accountsByUserId = new HashMap<>();

    public void save(Account account) {
        accountsByUserId.put(account.getOwnerId(), account);
    }

    public Optional<Account> findByUserId(UUID userId) {
        return Optional.ofNullable(accountsByUserId.get(userId));
    }
}
