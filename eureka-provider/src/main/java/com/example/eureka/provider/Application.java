package com.example.eureka.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
    @Value("${spring.application.name}")
    private String appName;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/ping")
    public String ping() {
        logger.info("Got /ping");
        return "pong from " + AppName.name(appName) + "\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
