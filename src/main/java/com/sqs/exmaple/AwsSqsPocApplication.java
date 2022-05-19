package com.sqs.exmaple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AwsSqsPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsPocApplication.class, args);
    }

}
