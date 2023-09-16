package com.nb.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.nb.emailservice.adapters.EmailSenderGateway;
import com.nb.emailservice.core.EmailSenderUseCase;

public class EmailSenderService implements EmailSenderUseCase{
    
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway){
        this.emailSenderGateway = emailGateway;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body){
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
