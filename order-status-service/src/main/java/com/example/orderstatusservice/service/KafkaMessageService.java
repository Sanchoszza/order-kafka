package com.example.orderstatusservice.service;

import com.example.orderstatusservice.model.OrderEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaMessageService {

    private final List<OrderEvent> orderEvents = new ArrayList<>();

    public void add(OrderEvent orderEvent){
        orderEvents.add(orderEvent);
    }

}
