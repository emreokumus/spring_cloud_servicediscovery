package com.emreokumus.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieClientApplication.class,args);
    }
}
