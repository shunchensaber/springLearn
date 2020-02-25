package com.example.actorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * It also turns on Spring MVC’s @EnableWebMvc annotation, which activates web endpoints.
 */
public class ActorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActorServiceApplication.class, args);
    }

}
