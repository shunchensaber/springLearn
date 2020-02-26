package com.example.messagingjms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox",containerFactory = "myFactory")
    public void ReceiveMessage(Email email)
    {
        System.out.println("Received:<"+email+">");
    }
}
