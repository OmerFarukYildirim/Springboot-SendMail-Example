package com.MailExample.Services.Interface;

import jakarta.mail.MessagingException;

public interface MailService {
    String SendMail();
    String SendMultiMail() throws MessagingException;
}
