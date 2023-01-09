package com.wunmi.BankApplication.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.security.SecureRandom;

@Getter
@Document
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
    @Setter
    @NonNull
    private String firstName;
    @Setter
    @NonNull
    private String lastName;
    @Setter
    @NonNull
    private String phoneNumber;
    @Setter
    @NonNull
    private String email;
    @Setter
    private String accountNumber;
    @Getter
    @Setter
    private BigDecimal balance = BigDecimal.ZERO;
    @Getter
    @Setter
    private String pin;
    @Getter
    @Setter
    @Id
    private String id;

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
        number = number % 100_000_000L;
        return String.valueOf(number);
    }

    public String getAccountNumber(){
        return "3" + generateAccountNumber();
    }

}
