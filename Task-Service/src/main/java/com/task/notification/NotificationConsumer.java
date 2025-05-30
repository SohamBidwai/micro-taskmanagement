package com.task.notification;

import com.task.email.EmailNotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @KafkaListener(topics = "task-event", groupId = "notification-group")   //notification-group this id come from application.propertires file.
    public void consumeTaskEvent(ConsumerRecord<String, String> record) {

        try {
            System.out.println("📥 Received raw Kafka record: " + record);
            String message = record.value();
            System.out.println("✅ Message value: " + message);

            // Simulate processing
            // Do something here...

            sendNotification(record.value());

        } catch (Exception e) {
            System.err.println("❌ Error while processing Kafka message: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow so Kafka can retry (optional)
        }

    }

    private void sendNotification(String message) {
        // Logic to send email/SMS notification

        String senderToMailId = "to_email_id";
        String subject = "mail_subject";
        String body = "mail_message_body";

        emailNotificationService.sendTaskMailToUser(senderToMailId, subject, body);
        
        System.out.println("Sending notification: " + message);
    }

}
