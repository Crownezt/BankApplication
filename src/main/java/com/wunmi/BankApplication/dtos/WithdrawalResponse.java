package com.wunmi.BankApplication.dtos;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class WithdrawalResponse {
    @NonNull
    private String message;
    private BigDecimal balance;

}
