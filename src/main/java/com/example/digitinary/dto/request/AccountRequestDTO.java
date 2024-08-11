package com.example.digitinary.dto.request;

import com.example.digitinary.entity.enums.AccountStatus;
import com.example.digitinary.entity.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public abstract class AccountRequestDTO {
    private String customerUUID;
    private String customerId;
    private AccountType accountType;
    private BigDecimal balance;
    private String createdBy;
    private String modifiedBy;
    private AccountStatus accountStatus;


}
