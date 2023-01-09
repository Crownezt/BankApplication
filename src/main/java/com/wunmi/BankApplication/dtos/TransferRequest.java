package com.wunmi.BankApplication.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
public class TransferRequest {
    private BigDecimal transferAmount;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private String senderPin;
}
