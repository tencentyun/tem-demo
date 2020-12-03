package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "eureka-client", configuration = MyRibbonConfig.class)
public class Application {
    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

//    @RequestMapping("/eureka-node-list")
//    public String nodeList() {
//    }

    @RequestMapping("/eureka-ping")
    public String eurekaPing() {
        return this.restTemplate.getForObject(
                "http://eureka-client/ping", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
