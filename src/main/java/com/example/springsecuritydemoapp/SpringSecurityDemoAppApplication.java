package com.example.springsecuritydemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class SpringSecurityDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
    }

}
