package com.fon.knjizarafrontend.service.impl;

import com.fon.knjizarafrontend.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    @Override
    public void sendMail(String to, String subject, String text) {


        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromMail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file
                    = new FileSystemResource(new File("static"));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);


            /*
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
            */

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
