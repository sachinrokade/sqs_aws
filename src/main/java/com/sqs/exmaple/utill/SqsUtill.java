package com.sqs.exmaple.utill;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SqsUtill {


    @Autowired
    private AmazonSQS amazonSQS;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public List<String> getQList() {

        List<String>  listQueuesResult = amazonSQS.listQueues().getQueueUrls();
        return listQueuesResult;
    }
}
