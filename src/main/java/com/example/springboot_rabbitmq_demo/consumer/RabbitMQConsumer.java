package com.example.springboot_rabbitmq_demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = ("${rabbitmq.queue.name}")) // @ is used to read & consume particular msg from Queue
    public void consume(String message){
        log.info(String.format("received message -> %s", message));
    }
}
