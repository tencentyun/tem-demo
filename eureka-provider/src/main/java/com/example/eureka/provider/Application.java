package com.example.eureka.provider;

import com.example.common.AppName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/ping")
    public String ping() {
        return "pong from " + AppName.name(appName) + "\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}