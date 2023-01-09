package com.wunmi.BankApplication.services;

import com.wunmi.BankApplication.dtos.*;

import com.wunmi.BankApplication.exceptions.AccountNumberAlreadyExistException;

public interface AccountServices {
    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws AccountNumberAlreadyExistException;
    ViewAccountResponse viewAccount(ViewAccountRequest viewAccount);
    DepositResponse deposit(DepositRequest request);
    WithdrawalResponse withdraw(WithdrawalRequest request);
    public TransferResponse transfer(TransferRequest request);

}
