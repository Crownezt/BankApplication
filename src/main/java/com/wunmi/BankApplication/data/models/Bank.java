package com.wunmi.BankApplication.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document
public class Bank {
    private String name;
    private String address;
    private List<Account> accounts = new ArrayList<>();
}
