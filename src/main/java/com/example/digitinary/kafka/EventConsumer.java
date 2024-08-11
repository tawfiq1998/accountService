package com.example.digitinary.kafka;

import com.example.digitinary.dto.request.AccountRequestDTO;
import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import com.example.digitinary.service.impl.AccountKafkaServiceImpl;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;


@Slf4j
@RequiredArgsConstructor
public class EventConsumer {

    private final AccountKafkaServiceImpl accountKafkaService;

    @KafkaListener(topics = "Account", groupId = "group_id")
    public void consume(String message) {
        Gson gson = new Gson();
        AccountRequestDTO accountDTO = gson.fromJson(message, CreateAccountRequestDTO.class);
        log.info("Received message: {}", message);

        accountKafkaService.createAccount(accountDTO);
    }
}
