package com.MailExample.Services.Impl;

import com.MailExample.Services.Interface.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailServiceImpl implements MailService {


    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    public String SendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("noreply@gmail.com");
        mailMessage.setTo("aahmetyldrm99@gmail.com");
        mailMessage.setText("Ben Java ile oluşturulan bir mailim. Ahmet reisin daşşanı yerim.");
        mailMessage.setSubject("ABDUNUN ÇÜKÜ");
        mailSender.send(mailMessage);
        return "Gönderildi";
    }

    @Override
    public String SendMultiMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message=new MimeMessageHelper(mimeMessage,true);
        message.setFrom("noreply@gmail.com");
        message.setTo("aahmetyldrm99@gmail.com");
        message.setText("Ben Java ile oluşturulan bir mailim. Ahmet reisin daşşanı yerim.");
        message.setSubject("ABDUNUN ÇÜKÜ");
        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\YILDIRIM\\Pictures\\FB_IMG_1616177792075.jpg"));
        message.addAttachment("FB_IMG_1616177792075.jpg",file);
        mailSender.send(mimeMessage);
        return "Gönderildi";
    }
}
