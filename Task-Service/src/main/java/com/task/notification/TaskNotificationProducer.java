package com.task.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskNotificationProducer {

 private final KafkaTemplate<String, String> kafkaTemplate;

    public TaskNotificationProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(String eventListener){
        kafkaTemplate.send("task-event",eventListener);
    }
}
