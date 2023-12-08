package com.microservice.two.controller;


import com.microservice.two.domain.TaskDto;
import com.microservice.two.service.CalculationService;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationController {

    private final CalculationService calculationService;

    /**
     * Constructs a CalculationController instance.
     *
     * @param calculationService The service responsible for performing calculations on tasks.
     */
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    /**
     * Handles an HTTP POST request to receive and process a task.
     *
     * @param task The Task object containing data for the calculation.
     * @return A string indicating the status of the task processing.
     */
    @PostMapping("/receiveTask")
    public String receiveTask(@RequestBody TaskDto task) {

        System.out.println("Received Task: " + task);
        calculationService.performFakeCalculation(task);

        return "Task received and processed";
    }
}