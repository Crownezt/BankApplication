package com.wunmi.BankApplication.data.repositories;

import com.wunmi.BankApplication.data.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByAccountNumber(String email);
    Optional<Account> findByEmail(String email);
}
