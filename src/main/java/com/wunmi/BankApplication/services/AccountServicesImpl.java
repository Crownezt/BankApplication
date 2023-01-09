package com.wunmi.BankApplication.services;

import com.wunmi.BankApplication.dtos.*;
import com.wunmi.BankApplication.data.models.Account;
import com.wunmi.BankApplication.data.repositories.AccountRepository;

import com.wunmi.BankApplication.exceptions.AccountNumberAlreadyExistException;
import com.wunmi.BankApplication.exceptions.EmailAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wunmi.BankApplication.util.ModelMapper;

import java.math.BigDecimal;
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
    public ViewAccountResponse viewAccount(ViewAccountRequest viewAccount) {
        return null;
    }

    @Override
    public DepositResponse deposit(DepositRequest request) {
        Account account = new Account();
        Optional<Account> accountToCredit = accountRepository.findByAccountNumber(request.getAccountNumber());
        if (accountToCredit.isPresent()) {
            boolean amountValidation = request.getDepositAmount().compareTo(BigDecimal.ZERO) > 0;
            if (amountValidation) {
                BigDecimal balance = accountToCredit.get().getBalance().add(request.getDepositAmount());
                account.setBalance(balance);
                accountRepository.save(account);
                return new DepositResponse("Successful, Your balance is ", balance);
            } else return new DepositResponse("Invalid amount");
        }
        return new DepositResponse("Account not found");
    }

    @Override
    public WithdrawalResponse withdraw(WithdrawalRequest request) {
        Optional<Account> accountToDebit = accountRepository.findByAccountNumber(request.getAccountNumber());
        if (accountToDebit.isPresent()) {
            Account account = new Account();
            boolean pinValidation = account.getPin().equals(request.getPin());
            boolean amountValidation = accountToDebit.get().getBalance().compareTo(request.getWithdrawalAmount()) > 0;
            if (pinValidation) {
                if (amountValidation) {
                    BigDecimal balance = account.getBalance().subtract(request.getWithdrawalAmount());
                    return new WithdrawalResponse("Transaction successful, Your balance is ", balance);
                } else return new WithdrawalResponse("Insufficient Balance", account.getBalance());
            } else return new WithdrawalResponse("Invalid pin");
        }
        return new WithdrawalResponse("Account not found");
    }

    public TransferResponse transfer(TransferRequest request) {
        WithdrawalRequest withdrawalRequest = new WithdrawalRequest(request.getSenderAccountNumber(),
                request.getTransferAmount(), request.getSenderPin());
        DepositRequest depositRequest = new DepositRequest(request.getReceiverAccountNumber(), request.getTransferAmount());
        return new TransferResponse("Transfer Successful");
    }


//    private void withdraw(BigDecimal amount) {
//    }


}
