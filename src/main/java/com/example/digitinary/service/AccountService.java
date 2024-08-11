package com.example.digitinary.service;

import com.example.digitinary.dto.request.BalanceRequestDTO;
import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import com.example.digitinary.dto.request.EditAccountRequestDTO;
import com.example.digitinary.entity.enums.AccountStatus;

import java.math.BigDecimal;

public interface AccountService {

    void changeAccountStatus(Long id, AccountStatus accountStatus);
    void addBalance(BalanceRequestDTO balanceRequestDTO);
    void removeBalance(BalanceRequestDTO balanceRequestDTO);
}
