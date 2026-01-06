package com.example.mqtt_example.controller;

import com.example.mqtt_example.model.Message;
import com.example.mqtt_example.service.MqttSevice;
import org.apache.tomcat.util.json.JSONParser;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.util.JSONPObject;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttSevice sevice;

    @Value("${mqtt.clientId}")
    private String clientId;

    @GetMapping("/")
    public ResponseEntity<String> sendDefault(){
        try {
            Message m = new Message(clientId, "testowa wiadomosc", LocalDateTime.now());
            ObjectMapper om = new ObjectMapper();

            sevice.publish(m);

//            sevice.publish("["+clientId+"] testowa wiadomosc ");
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body("wiadomość zostałą wysłąna");
    }
}
