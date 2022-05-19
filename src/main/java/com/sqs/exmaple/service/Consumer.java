package com.sqs.exmaple.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Consumer {

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Autowired
    private AmazonSQS amazonSQS;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;


//    @SqsListener(value = "TestQueue",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
//    public void processMessage(Data message) {
//
//        log.info("Message from SQS {}", message);
//    }

    public List<String> receiveMessages() {

        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(endpoint)
                .withMaxNumberOfMessages(1)
                .withWaitTimeSeconds(3);

        List<com.amazonaws.services.sqs.model.Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();
      List<String> message=new ArrayList<>();
        for (Message messageObject : messages)
        {
            log.info("message == "+messageObject.getBody());
            message.add(messageObject.getBody());
        }
        return  message;
    }
}
