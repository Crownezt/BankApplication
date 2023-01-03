package com.wunmi.BankApplication.services;

import com.wunmi.BankApplication.dtos.*;

import com.wunmi.BankApplication.exceptions.AccountNumberAlreadyExistException;

public interface AccountServices {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws AccountNumberAlreadyExistException;
    DepositResponse deposit(DepositRequest request);
    WithdrawalResponse withdrawal(WithdrawalRequest request);

}
