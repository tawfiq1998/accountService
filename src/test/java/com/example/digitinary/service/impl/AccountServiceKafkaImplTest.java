package com.example.digitinary.service.impl;


import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import com.example.digitinary.entity.Account;
import com.example.digitinary.repository.AccountRepository;
import com.example.digitinary.kafka.EventProducer;
import com.example.digitinary.service.mapper.AccountMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountServiceKafkaImplTest {
    @InjectMocks
    private AccountKafkaServiceImpl accountKafkaService;
    @Mock
    private AccountMapper accountMapper;
    @Mock
    private AccountRepository accountRepository; // Mock the repository

    @Mock
    private EventProducer eventProducer;

    @Test
    @Order(1)
    void createAccount() {
        CreateAccountRequestDTO requestDTO = new CreateAccountRequestDTO();
        Account account = mock(Account.class);

        given(accountRepository.save(account)).willReturn(account);

        when(accountMapper.createAccountDTOToCustomer(requestDTO)).thenReturn(account);
        doNothing().when(eventProducer).sendEvent(any(),any());

        accountKafkaService.createAccount(requestDTO);

        verify(accountRepository, times(1)).save(account);
        verify(eventProducer, times(1)).sendEvent(any(),any());
    }

}
