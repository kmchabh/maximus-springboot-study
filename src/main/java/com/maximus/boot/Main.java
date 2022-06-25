package com.maximus.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }
}