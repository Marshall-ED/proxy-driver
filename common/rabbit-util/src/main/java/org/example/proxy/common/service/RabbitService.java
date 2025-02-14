package org.example.proxy.common.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Marshall
 * @Date 2025/2/12 14:54
 * @Description:
 */
@Service
public class RabbitService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //send Messages
    public boolean sendMessage(String exchange,
                               String routingkey,
                               Object message) {
        rabbitTemplate.convertAndSend(exchange,routingkey,message);
        return true;
    }
}
