package com.example.springboot_rabbitmq_demo.controller;

import com.example.springboot_rabbitmq_demo.dto.User;
import com.example.springboot_rabbitmq_demo.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MessageJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);

        return ResponseEntity.status(200).body("Json message sent to RabbitMQ");
    }
}
