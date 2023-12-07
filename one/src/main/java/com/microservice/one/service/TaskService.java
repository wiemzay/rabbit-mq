package com.microservice.one.service;

import com.microservice.one.domain.Task;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public TaskService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTaskToRabbitMQ(Task task) {
        // Logic to send the task to RabbitMQ queue
        rabbitTemplate.convertAndSend(exchange, routingKey, task);
    }
}
