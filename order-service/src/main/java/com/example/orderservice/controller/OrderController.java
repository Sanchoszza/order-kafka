package com.example.orderservice.controller;

import com.example.orderservice.model.KafkaMessage;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.KafkaMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    @Value("${app.kafka.orderTopic}")
    private String topicName;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    private final KafkaMessageService kafkaMessageService;

    @PostMapping
    public ResponseEntity<String> sendOrder(@RequestBody Order order){
        kafkaTemplate.send(topicName, order);

        return ResponseEntity.ok("Order was add");
    }
}
