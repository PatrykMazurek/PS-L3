package com.example.mqtt_example.configuration;

import com.example.mqtt_example.SimpleMqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Value("${mqtt.clientId}")
    private String userId;
    @Value("${mqtt.hostname}")
    private String hostname;
    @Value("${mqtt.port}")
    private String port;
    @Value("${mqtt.defaultTopic}")
    private String defaultTopic;

    @Bean
    public SimpleMqttCallback simpleMqttCalback(){
        return new SimpleMqttCallback();
    }

    @Bean
    public MqttClient mqttClient(SimpleMqttCallback calback) throws MqttException {
        MqttClient mqtt = new MqttClient(hostname + ":" + port, userId, new MemoryPersistence());

        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setAutomaticReconnect(true);
        // jeśli masz user/pass na brokerze, odkomentuj:
        // options.setUserName("twojUser");
        // options.setPassword("twojeHaslo".toCharArray());
        mqtt.setCallback(calback);
        mqtt.connect(options);

        mqtt.subscribe(defaultTopic);
        return mqtt;
    }

}
