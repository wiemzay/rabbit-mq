package com.microservice.one;

import com.microservice.one.domain.Task;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {

    private final TaskRepository taskRepository;

    public TaskListener(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveTask(Task task) {
        System.out.println("Fake Calculation Result for task " + task.getDescription() + " = " +task.getResult() );
    }
}
