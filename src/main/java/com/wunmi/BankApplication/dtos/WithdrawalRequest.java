package com.wunmi.BankApplication.dtos;

import com.wunmi.BankApplication.data.models.User;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class WithdrawalRequest {
    private User user;
    private BigDecimal amount;


}
