package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("app1")
public class Listener1 {

    @Autowired
    MessageProducer messageProducer;

    @KafkaListener(topics = "${message.topic.name2:topic2}", groupId = "${message.group.name:group1}")
    public void listenTopic2(String mensaje){
        System.out.println("mensaje recibido de topic2" + mensaje);
    }
}
