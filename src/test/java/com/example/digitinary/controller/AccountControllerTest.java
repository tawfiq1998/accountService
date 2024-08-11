
package com.example.digitinary.controller;

import com.example.digitinary.dto.request.BalanceRequestDTO;
import com.example.digitinary.entity.enums.AccountStatus;
import com.example.digitinary.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {


    @Mock
    private AccountService accountService;

    private AccountController accountController;

    @BeforeEach
    public void setUp() {
        accountController = new AccountController(accountService);
    }

    @Test
    void testCreateCustomer(){
        accountController.changeAccountStatus(1L, AccountStatus.ACTIVE);
        verify(accountService, times(1)).changeAccountStatus(any(), any());
    }

    @Test
    void testEditCustomer(){
        BalanceRequestDTO requestDTO = new BalanceRequestDTO();

        accountController.addToBalance(requestDTO);

        verify(accountService, times(1)).addBalance(any(BalanceRequestDTO.class));
    }

    @Test
    void testChangeCustomerStatus(){
        BalanceRequestDTO requestDTO = new BalanceRequestDTO();

        accountController.removeBalance(requestDTO);

        verify(accountService, times(1)).removeBalance(any(BalanceRequestDTO.class));
    }

}
