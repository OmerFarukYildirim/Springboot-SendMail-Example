package com.MailExample.Controller;

import com.MailExample.Services.Interface.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MailController {
    private final MailService mailService;
    @Autowired
    public MailController( MailService mailService) {
        this.mailService = mailService;
    }
    @GetMapping("/mail")
    public ResponseEntity<String> SendMail()
    {
        return ResponseEntity.ok(mailService.SendMail());
    }
    @GetMapping("/multi-mail")
    public ResponseEntity<String> SendMultiMail() throws MessagingException {
        return ResponseEntity.ok(mailService.SendMultiMail());
    }
}
