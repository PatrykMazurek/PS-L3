package com.example.mqtt_example;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class SimpleMqttCallback implements MqttCallback {

    private static final Logger log = LoggerFactory.getLogger(SimpleMqttCallback.class);

    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("Połączenie MQTT utracone", throwable);
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String payload = new String(mqttMessage.getPayload(), StandardCharsets.UTF_8);
        log.info("Odebrano wiadomość. Topic: {}, payload: {}", s, payload);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.debug("Wiadomość dostarczona: {}", token.getMessageId());
    }
}
