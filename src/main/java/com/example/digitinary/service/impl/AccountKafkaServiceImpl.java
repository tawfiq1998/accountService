package com.example.digitinary.service.impl;

import com.example.digitinary.dto.request.AccountRequestDTO;
import com.example.digitinary.entity.Account;
import com.example.digitinary.repository.AccountRepository;
import com.example.digitinary.kafka.EventProducer;
import com.example.digitinary.service.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class AccountKafkaServiceImpl {

    private final AccountRepository accountRepository;
    private final EventProducer eventProducer;
    private final AccountMapper accountMapper;
    private final Random random = new Random();

    public void createAccount(AccountRequestDTO accountRequestDTO) {
        Long counted = accountRepository.countAccountByCustomerUUID(accountRequestDTO.getCustomerUUID());
        if (counted > 6) {
            eventProducer.sendEvent("Customer", "Account with customer Id :" + accountRequestDTO.getCustomerUUID() + " reached the max limit");
        return;
        }

        Account account = accountMapper.createAccountDTOToCustomer(accountRequestDTO);
        account.setAccountNumber(addRandomDigits(accountRequestDTO.getCustomerId()));
        accountRepository.save(account);
        eventProducer.sendEvent("Customer", "Account with customer Id :" + account.getCustomerUUID() + " created");
    }

    public String addRandomDigits(String str) {
        int randomDigits = 100 + random.nextInt(900); // Generates a random 3-digit number (100-999)
        return str + randomDigits;
    }
}
