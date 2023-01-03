package com.wunmi.BankApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WithdrawalResponse {
    private String message;
    private BigDecimal balance;

}
