package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerKafka {

    @Autowired
    MessageProducer messageProducer;

    @PostMapping("add/{topic}")
    public void recibirMensaje(@PathVariable String topic, @RequestBody String body){
        messageProducer.enviarMensaje(topic,body);
    }
}
