package com.communicators.welltalk.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("alferkesa@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    // public void sendMessageWithAttachment(String to, String subject, String text,
    // String pathToAttachment) {
    // MimeMessage message = mailSender.createMimeMessage();

    // MimeMessageHelper helper = new MimeMessageHelper(message, true);

    // try {
    // helper.setFrom("alferkesa@gmail.com");
    // helper.setTo(to);
    // helper.setSubject(subject);
    // helper.setText(text);

    // FileSystemResource file = new FileSystemResource(pathToAttachment);
    // helper.addAttachment("Invoice", file);

    // mailSender.send(message);
    // } catch (MailException e) {
    // e.printStackTrace();
    // } catch (MessagingException e) {
    // e.printStackTrace();
    // }
    // }

    public void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("kheisaselma0227@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        mailSender.send(message);
    }
}
