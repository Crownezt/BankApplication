package com.wunmi.BankApplication.controllers;

import com.wunmi.BankApplication.dtos.CreateAccountRequest;
import com.wunmi.BankApplication.dtos.CreateAccountResponse;
import com.wunmi.BankApplication.exceptions.EmailAlreadyExistException;
import com.wunmi.BankApplication.services.AccountServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("bank")
public class AccountController {
    private final AccountServices accountServices;

    @PostMapping("account")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        try {
         CreateAccountResponse response = accountServices.createAccount(createAccountRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(EmailAlreadyExistException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
