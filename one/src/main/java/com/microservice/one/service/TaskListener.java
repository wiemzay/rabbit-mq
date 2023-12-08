package com.microservice.one.service;

import com.microservice.one.domain.Task;
import com.microservice.one.repository.TaskRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {
    private final TaskRepository taskRepository;

    public TaskListener(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveTask(Task task) {
        taskRepository.findById(task.getId()).ifPresent(task1 -> {
            task1.setResult(task.getResult());
            taskRepository.save(task1);
        });
        System.out.println("Fake Calculation Result for task " + task.getDescription() + " = " +task.getResult() );
    }
}
