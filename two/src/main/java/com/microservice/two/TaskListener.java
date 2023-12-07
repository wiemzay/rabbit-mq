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
        // Perform calculation
        String result = calculationService.performFakeCalculation();

        // Simulate sending the result back to the first application
        System.out.println("Fake Calculation Result: " + result);
    }
}
