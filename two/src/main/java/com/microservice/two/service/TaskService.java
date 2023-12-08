package com.microservice.two.service;


import com.microservice.two.domain.TaskDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The TaskService class is responsible for sending tasks to RabbitMQ.
 */
@Service
public class TaskService {


    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    /**
     * Constructs a TaskService with the specified RabbitTemplate.
     *
     * @param rabbitTemplate The RabbitTemplate used for sending tasks to RabbitMQ.
     */
    public TaskService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Sends the given task to RabbitMQ.
     *
     * @param task The task to be sent to RabbitMQ.
     */
    public void sendTaskToRabbitMQ(TaskDto task) {
        rabbitTemplate.convertAndSend(exchange, routingKey, task);
    }
}
