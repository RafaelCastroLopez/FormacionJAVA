package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.KafkaMessageHeaders;
import org.springframework.stereotype.Component;

@Component
@Profile("app2")
public class Listener2 {

    @Autowired
    MessageProducer messageProducer;

    @KafkaListener(topics = "${message.topic.name:topic1}", groupId = "${message.group.name:group1}")
    public void listenTopic1(String mensaje){
        System.out.println("mensaje recivido de topic1" + mensaje);
        messageProducer.enviarMensaje("topic2", "mensaje recibido" + mensaje);
    }
}
