package com.eren.java_rabbitmq.consumer;

import com.eren.java_rabbitmq.dto.User;
import com.eren.java_rabbitmq.publisher.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJsonMessage(User user) {
        LOGGER.info(String.format("Receive Json Message: -> %s", user.toString()));
    }
}
