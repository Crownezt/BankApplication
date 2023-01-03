package com.wunmi.BankApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountResponse {
    private String message;
    private String accountNumber;



//    @Override
//    public String toString() {
//        Account account = new Account();
//        return String.format("Account creation for %s %s was successful." +
//                "%n the account number is %s",firstName,lastName, account.getAccountNumber());
//    }
}
