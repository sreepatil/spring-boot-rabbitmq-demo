package com.example.springboot_rabbitmq_demo.consumer;

import com.example.springboot_rabbitmq_demo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = ("${rabbitmq.queue.json.name}"))
    public void consumeJsonMessage(User user){
        log.info(String.format("received json message -> %s", user.toString()));
    }
}
