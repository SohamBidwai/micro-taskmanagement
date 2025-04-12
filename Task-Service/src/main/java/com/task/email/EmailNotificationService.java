package com.task.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTaskMailToUser(String senderMailId, String subject, String body){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("sohambidwai07@gmail.com");
        simpleMailMessage.setTo(senderMailId);
        simpleMailMessage.setCc("sohambidwai7@gmail.com");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

    }

}
