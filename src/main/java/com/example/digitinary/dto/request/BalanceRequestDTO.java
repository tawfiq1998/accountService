package com.example.digitinary.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceRequestDTO {
    private Long accountId;
    private int account;
    @Size(min = 0,message = "The entered amount should be positive")
    private BigDecimal amount;
}
