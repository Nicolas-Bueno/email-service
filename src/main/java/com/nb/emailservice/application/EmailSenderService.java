package com.nb.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nb.emailservice.adapters.EmailSenderGateway;
import com.nb.emailservice.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{
    
    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway){
        this.emailSenderGateway = emailSenderGateway;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body){
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
