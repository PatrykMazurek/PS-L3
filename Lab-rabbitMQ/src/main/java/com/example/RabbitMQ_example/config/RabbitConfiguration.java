package com.example.RabbitMQ_example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${app.rabbitmq.queue}")
    private String queueName;

    @Value("${app.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    // 1. Tworzymy Kolejkę
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    // 2. Tworzymy Exchange (typu Direct - najprostszy)
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    // 3. Wiążemy Kolejkę z Exchangem za pomocą Klucza (Binding)
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

//    // DODAJ TO: Mówimy Springowi, żeby używał Jacksona do konwersji na JSON
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
}
