package com.task.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTaskMailToUser(String senderToMailId, String subject, String body){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("from_mail_id");
        simpleMailMessage.setTo(senderToMailId);
        simpleMailMessage.setCc("cc_email_id");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

    }

}
