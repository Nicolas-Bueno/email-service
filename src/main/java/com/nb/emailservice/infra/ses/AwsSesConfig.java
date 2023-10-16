package com.nb.emailservice.infra.ses;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;

@Configuration
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIA2EZKOPUTVYG7K6VC", "CzrBY+ce1KWibXjqdtJ/sI0b7zYjqF7CRLKqzEVl");
        return AmazonSimpleEmailServiceClient.builder()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1) // Defina a região desejada
                .build();
    }
}

