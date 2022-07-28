package com.kafka.controller;

import com.kafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish2")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafka(@PathParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
