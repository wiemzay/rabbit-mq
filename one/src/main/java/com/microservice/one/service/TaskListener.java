package com.microservice.one.service;

import com.microservice.one.domain.Task;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {


    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveTask(Task task) {
        System.out.println("Fake Calculation Result for task " + task.getDescription() + " = " +task.getResult() );
    }
}
