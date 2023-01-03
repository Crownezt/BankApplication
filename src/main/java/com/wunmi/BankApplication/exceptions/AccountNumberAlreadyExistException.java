package com.wunmi.BankApplication.exceptions;

public class AccountNumberAlreadyExistException extends BankAppException {
    public AccountNumberAlreadyExistException(String message) {
        super(message);

    }
}
