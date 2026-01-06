package com.example.RabbitMQ_example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitProducer.class);

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    // Wstrzykiwanie przez konstruktor
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Wysyłanie wiadomości -> %s", message));

        // Magiczna linijka wysyłająca dane
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
