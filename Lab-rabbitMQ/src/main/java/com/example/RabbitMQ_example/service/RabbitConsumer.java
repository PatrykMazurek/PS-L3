package com.example.RabbitMQ_example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConsumer.class);

    // Nasłuchujemy na konkretnej kolejce zdefiniowanej w properties
    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void consume(String message) {
        LOGGER.info(String.format("Odebrano wiadomość -> %s", message));

        // Tutaj robisz swoją logikę biznesową z otrzymanymi danymi
    }

}
