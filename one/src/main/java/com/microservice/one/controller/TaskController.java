package com.microservice.one.controller;
import com.microservice.one.TaskRepository;
import com.microservice.one.domain.Task;
import com.microservice.one.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public TaskController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        taskService.sendTaskToRabbitMQ(task);
        return taskRepository.save(task);
    }

    // other CRUD operations if needed
}

