package com.wunmi.BankApplication.dtos;

import com.wunmi.BankApplication.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class WithdrawalRequest {

    private String accountNumber;
    private BigDecimal withdrawalAmount;
    private String pin;

}
