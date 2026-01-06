package com.example.mqtt_example.service;

import com.example.mqtt_example.model.Message;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class MqttSevice {

    @Autowired
    private MqttClient mqttClient;

    @Value("${mqtt.defaultTopic}")
    private String defaultTopic;

    public void publish(String payload) throws MqttException {
        publish(defaultTopic, payload);
    }

    public void publish(Message mess) throws  MqttException{
        MqttMessage message = new MqttMessage(mess.toString().getBytes(StandardCharsets.UTF_8));
        message.setQos(0);
        mqttClient.publish(defaultTopic, message);
    }

    public void publish(String topic, String payload) throws MqttException{
        MqttMessage message = new MqttMessage(payload.getBytes(StandardCharsets.UTF_8));
        message.setQos(0);
//        message.setRetained();
        mqttClient.publish(topic, message);
    }

    public void subscribe(String topic, int qos) throws MqttException {
        mqttClient.subscribe(topic, qos);
    }

    public void subscribe(String topic) throws MqttException {
        subscribe(topic, 0);
    }


}
