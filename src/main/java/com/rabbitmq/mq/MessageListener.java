package com.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {


    @RabbitListener(queues = MQConfig.api_queue)
    public void messageListener(CustomMessage message){
        System.out.println(message);
    }
}
