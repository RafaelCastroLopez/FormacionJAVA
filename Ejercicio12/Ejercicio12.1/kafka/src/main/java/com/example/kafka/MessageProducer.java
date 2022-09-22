package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.kafka.support.SendResult;

@Component
public class MessageProducer {

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name:topic1}")
    public String topicName;

    public void enviarMensaje(String topic, String mensaje){
        if (topic==null || topic.trim().equals(""))
            topic = topicName;

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, mensaje);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String,String> result){
                System.out.println("mensaje enviado [" + mensaje + "] a [" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.err.println("imposible mandar el mensaje[" + mensaje + "] por:" + ex.getMessage() );
            }
        });
    }
}
