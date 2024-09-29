package com.communicators.welltalk.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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

    // ClassPathResource file = new ClassPathResource(pathToAttachment);
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

    public void sendHtmlMessage(String to, String subject, String htmlBody, String pathToImage1, String pathToImage2)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("alferkesa@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);

        // Embedding first image (from the classpath)
        ClassPathResource res1 = new ClassPathResource(pathToImage1);
        helper.addInline("imageId1", res1);

        // Embedding second image (from the classpath)
        ClassPathResource res2 = new ClassPathResource(pathToImage2);
        helper.addInline("imageId2", res2);

        mailSender.send(message);
    }

}
