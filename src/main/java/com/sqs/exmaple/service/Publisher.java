package com.sqs.exmaple.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.sqs.exmaple.pojo.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class Publisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;


    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    public void scheduleFixedRateTask(Data data) {
        log.info("Sending Message to SQS ");
        queueMessagingTemplate.convertAndSend(endpoint,data);

    }
}
