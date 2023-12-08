package com.microservice.one.service;

import com.microservice.one.domain.Task;
import com.microservice.one.repository.TaskRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The TaskListener class is a component responsible for listening to RabbitMQ messages.
 * It receives Task objects from the specified queue, updates the corresponding task in the repository,
 * and performs a fake calculation with the received result.
 */
@Component
public class TaskListener {

    private final TaskRepository taskRepository;

    /**
     * Constructor for TaskListener.
     *
     * @param taskRepository TaskRepository for handling Task entities.
     */
    public TaskListener(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * RabbitMQ message listener method.
     * Receives Task objects from the specified queue, updates the corresponding task in the repository,
     * and performs a fake calculation with the received result.
     *
     * @param task The Task object received from RabbitMQ.
     */
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveTask(Task task) {
        taskRepository.findById(task.getId()).ifPresent(task1 -> {
            task1.setResult(task.getResult());
            taskRepository.save(task1);
        });
        System.out.println("Fake Calculation Result for task " + task.getDescription() + " = " +task.getResult() );
    }
}
