package com.wunmi.BankApplication.exceptions;

public class EmailAlreadyExistException extends BankAppException{

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
