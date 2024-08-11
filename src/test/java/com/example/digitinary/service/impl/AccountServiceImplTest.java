package com.example.digitinary.service.impl;


import com.example.digitinary.dto.request.BalanceRequestDTO;
import com.example.digitinary.entity.Account;
import com.example.digitinary.entity.enums.AccountStatus;
import com.example.digitinary.repository.AccountRepository;
import com.example.digitinary.service.mapper.AccountMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceImplTest {
    @InjectMocks
    private AccountServiceImpl accountService;
    @Mock
    private AccountMapper accountMapper;
    @Mock
    private AccountRepository accountRepository; // Mock the repository

    @Test
    @Order(1)
    void createAccount() {
        mock(Account.class);

        given(accountRepository.existsById(1L)).willReturn(true);
        doNothing().when(accountRepository).updateAccountStatusById(AccountStatus.ACTIVE, 1L);

        accountService.changeAccountStatus(1L, AccountStatus.ACTIVE);

        verify(accountRepository, times(1)).updateAccountStatusById(AccountStatus.ACTIVE, 1L);
    }

    @Test
    void editAccount() {
        BalanceRequestDTO requestDTO = mock(BalanceRequestDTO.class);
        when(requestDTO.getAmount()).thenReturn(new BigDecimal("1"));

        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(new BigDecimal("1"));

        given(accountRepository.save(account)).willReturn(account);
        given(accountRepository.findById(anyLong())).willReturn(Optional.of(account));

        accountService.addBalance(requestDTO);

        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void editCustomer_whenAccountNotFound() {
        BalanceRequestDTO requestDTO = mock(BalanceRequestDTO.class);
        when(requestDTO.getAmount()).thenReturn(new BigDecimal("1"));
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(new BigDecimal("1"));

        given(accountRepository.save(account)).willReturn(account);
        given(accountRepository.findById(anyLong())).willReturn(Optional.of(account));

        accountService.removeBalance(requestDTO);

        verify(accountRepository, times(1)).save(account);

    }

}
