package com.wunmi.BankApplication.services;

import com.wunmi.BankApplication.dtos.*;
import com.wunmi.BankApplication.data.models.Account;
import com.wunmi.BankApplication.data.repositories.AccountRepository;

import com.wunmi.BankApplication.exceptions.AccountNumberAlreadyExistException;
import com.wunmi.BankApplication.exceptions.EmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wunmi.BankApplication.util.ModelMapper;

import java.util.Optional;

@Service
public class AccountServicesImpl implements AccountServices {
    @Autowired
    private AccountRepository accountRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) throws AccountNumberAlreadyExistException {
        Optional<Account> existingEmail = accountRepository.findByEmail(createAccountRequest.getEmail());
        if (existingEmail.isPresent()) {
            throw new EmailAlreadyExistException("Email already exist!");
        }
        Account account = modelMapper.map(createAccountRequest);
        Account savedAcct = accountRepository.save(account);
        return new CreateAccountResponse("Successful, Your account number is ", savedAcct.getAccountNumber());
    }

    @Override
    public DepositResponse deposit(DepositRequest request) {
        Account account = new Account();
        account.setBalance(account.getBalance().add(request.getAmount()));
        return new DepositResponse("Successful",account.getBalance());
    }

    @Override
    public WithdrawalResponse withdrawal(WithdrawalRequest request) {
        Account account = new Account();
        if (account.getBalance().compareTo(request.getAmount()) > 0) {
            account.setBalance(account.getBalance().subtract(request.getAmount()));
            return new WithdrawalResponse("Your balance is ",account.getBalance());
        }
        else
            return new WithdrawalResponse("Insufficient Balance", account.getBalance());
    }

}
