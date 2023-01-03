package com.wunmi.BankApplication.dtos;

import lombok.Data;
import lombok.Getter;

@Data
public class CreateAccountRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;



}
