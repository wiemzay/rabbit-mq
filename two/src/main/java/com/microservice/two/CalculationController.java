package com.microservice.two;


import org.springframework.web.bind.annotation.*;

@RestController
public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/receiveTask")
    public String receiveTask(@RequestBody Task task) {

        System.out.println("Received Task: " + task);
        calculationService.performFakeCalculation(task);

        return "Task received and processed";
    }
}