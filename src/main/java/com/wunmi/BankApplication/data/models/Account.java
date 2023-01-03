package com.wunmi.BankApplication.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.security.SecureRandom;

@Data
@Document
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
    @Id
    private String accountNumber;

    private BigDecimal balance;

    public Account(String firstName, String lastName, String phoneNumber, String email,
                   String accountNumber, BigDecimal balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        if (balance.compareTo(BigDecimal.ZERO)>= 0) {
            this.balance = balance;
        }
    }

    private String generateAccountNumber() {
        SecureRandom random = new SecureRandom();
        long number = Math.abs(random.nextLong());
        number = number % 1_000_000_000L;
        return String.valueOf(number);
    }

    public String getAccountNumber(){
        return generateAccountNumber();
    }

}
