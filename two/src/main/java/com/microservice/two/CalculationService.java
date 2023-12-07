package com.microservice.two;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    private final TaskService taskService;

    public CalculationService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Cacheable(value = "calculationCache", key = "#task.id")
    public String performFakeCalculation(Task task) {
        long res = task.getId() * task.getDescription().length();
        task.setResult(res);
        taskService.sendTaskToRabbitMQ(task);
        return "Fake Calculation Result";
    }
}