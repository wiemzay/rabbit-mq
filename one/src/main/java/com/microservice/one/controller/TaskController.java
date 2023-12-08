package com.microservice.one.controller;
import com.microservice.one.domain.Task;
import com.microservice.one.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/tasks")
public class TaskController {



    @Value("${api.url-app2}")
    private String app2Url;
    private final RestTemplate restTemplate;
    private final TaskRepository taskRepository;

    /**
     * Constructor for TaskController.
     *
     * @param restTemplate   RestTemplate for making HTTP requests.
     * @param taskRepository TaskRepository for handling Task entities.
     */
    public TaskController(RestTemplate restTemplate, TaskRepository taskRepository) {
        this.restTemplate = restTemplate;
        this.taskRepository = taskRepository;
    }

    /**
     * Endpoint for creating a new task.
     *
     * @param task The Task object to be created.
     * @return A success message indicating that the task was sent successfully.
     */
    @PostMapping
    public String createTask(@RequestBody Task task) {
        taskRepository.save(task);
        restTemplate.postForObject(app2Url + "/receiveTask", task, String.class);
        return "Task sent successfully";
    }
}

