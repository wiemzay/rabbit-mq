package com.microservice.two;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {


    @Autowired
    private CalculationService calculationService;

    @RabbitListener(queues = "taskQueue")
    public void receiveTask(String taskDescription) {
        String result = calculationService.performFakeCalculation();

        System.out.println("Fake Calculation Result for task " + taskDescription + " = " + result);
    }
}
