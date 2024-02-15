package com.eren.java_rabbitmq.controller;

import com.eren.java_rabbitmq.dto.User;
import com.eren.java_rabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to queue...");
    }
}
