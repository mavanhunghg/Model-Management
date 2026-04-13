package com.model.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ModelManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelManagementApplication.class, args);
    }
}
