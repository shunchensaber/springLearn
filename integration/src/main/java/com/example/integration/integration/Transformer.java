package com.example.integration.integration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Transformer {
    public String transform(String filepath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filepath)));
        return "transformed:"+content;
    }

}
