package com.boart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@EnableAutoConfiguration
public class BoartApplication {
 
    @RequestMapping("/")
    String getGreeting() {
        return "Hello World!";
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(BoartApplication.class, args);
    }
}