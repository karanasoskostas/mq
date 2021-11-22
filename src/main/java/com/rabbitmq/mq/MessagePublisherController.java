package com.rabbitmq.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisherController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/mq/publish")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageType("1");
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.api_exchange , MQConfig.api_routingkey, message);

        return "Message Posted";
    }
}
