package com.sqs.exmaple.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.sqs.exmaple.pojo.Data;
import com.sqs.exmaple.service.Consumer;
import com.sqs.exmaple.service.Publisher;
import com.sqs.exmaple.utill.SqsUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class SqsController {

    @Autowired
    private AmazonSQS amazonSQS;
    @Autowired
    public Consumer consume;

    @Autowired
    public Publisher publisher;

    @Autowired
    public SqsUtill util;

    @GetMapping("/pub")
    public void publish() {

        publisher.scheduleFixedRateTask(new Data("Data - " + LocalDateTime.now()));
    }

    @GetMapping("/sub")
    public List<String> sub() {
        return consume.receiveMessages();
    }

    @GetMapping("/list")
    public List<String> qList() {
        return util.getQList();
    }
}
