package com.example.springboot_rabbitmq_demo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    // Spring Bean for RabbitMQ queue
    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    // Spring Bean for RabbitMQ exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    // Binding b/w queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routingKey);
    }
}
