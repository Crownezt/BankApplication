package com.wunmi.BankApplication.util;

import com.wunmi.BankApplication.data.models.Account;
import com.wunmi.BankApplication.dtos.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapper {
    @Autowired
    private Account account;
    public Account map(CreateAccountRequest createAccountRequest){
        Account account =new Account();
        account.setFirstName(createAccountRequest.getFirstName());
        account.setLastName(createAccountRequest.getLastName());
        account.setPhoneNumber(createAccountRequest.getPhoneNumber());
        account.setEmail(createAccountRequest.getEmail());
        account.getAccountNumber();
        return account;
    }
}
