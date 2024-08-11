package com.example.digitinary;

import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
public class DigitinaryTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitinaryTaskApplication.class, args);
    }
}

