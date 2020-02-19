package com.example.integration.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Autowired
    Transformer transform;
    @Bean
    public IntegrationFlow integrationFlow()
    {
        return IntegrationFlows.from(fileReader(),sp->{
            sp.poller(Pollers.fixedDelay(500)); 
        }).transform(transform,"transform")
                .handle(fileWriter()).get();
    }

    @Bean
    public FileWritingMessageHandler fileWriter() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("destination"));
        handler.setExpectReply(false);
        return handler;
    }
    @Bean
    public FileReadingMessageSource fileReader() {
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(new File("source"));
        return fileReadingMessageSource;
    }

}