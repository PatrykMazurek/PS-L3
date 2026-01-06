package com.example.RabbitMQ_example.controller;


import com.example.RabbitMQ_example.service.RabbitProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    private RabbitProducer producer;

    public RabbitController(RabbitProducer producer) {
        this.producer = producer;
    }

    // Wywołaj w przeglądarce: http://localhost:8080/wyslij?msg=PozdroDlaWariata
    @GetMapping("/wyslij")
    public String sendMessage(@RequestParam("msg") String message) {
        producer.sendMessage(message);
        return "Wiadomość wysłana do Rabbita!";
    }

}
