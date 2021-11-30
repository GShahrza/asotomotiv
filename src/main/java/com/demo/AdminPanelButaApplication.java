package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminPanelButaApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(AdminPanelButaApplication.class, args);
    }
}
