package com.example.eureka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RibbonClient(name = "eureka-provider", configuration = MyRibbonConfig.class)
@EnableFeignClients
public class Application {
//    @LoadBalanced
//    @Bean
//    RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    private LoadBalancerClient loadBalancer;

//    @RequestMapping("/eureka-node-list")
//    public String nodeList() {
//    }
    @Autowired
    private ProviderClient providerClient;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/ping-provider")
    public String pingProvider() {
        logger.info("got /ping-provider");
        return providerClient.ping() + " via " + AppName.name("eureka-provider");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
