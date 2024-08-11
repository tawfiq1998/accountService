
package com.example.digitinary.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendEvent(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}

