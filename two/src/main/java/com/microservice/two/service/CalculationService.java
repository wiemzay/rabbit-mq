package com.microservice.two.service;


import com.microservice.two.domain.TaskDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * The CalculationService class is responsible for performing fake calculations on tasks and sending them to RabbitMQ.
 */
@Service
public class CalculationService {
    private final TaskService taskService;

    /**
     * Constructs a CalculationService with the specified TaskService.
     *
     * @param taskService The TaskService used for sending tasks to RabbitMQ.
     */
    public CalculationService(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Performs a fake calculation on the given task, caches the result, and sends the task to RabbitMQ.
     *
     * @param task The task to perform the calculation on.
     */
    @Cacheable(value = "calculationCache", key = "#task.id")
    public void performFakeCalculation(TaskDto task) {
        long res = task.getId() * task.getDescription().length();
        task.setResult(res);
        taskService.sendTaskToRabbitMQ(task);
    }
}