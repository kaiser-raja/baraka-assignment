package com.baraka.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BarakaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarakaAssignmentApplication.class, args);
    }

}
