package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaMessageService {

    private final List<Order> orders = new ArrayList<>();

    public void add(Order order){
        orders.add(order);
    }

}
