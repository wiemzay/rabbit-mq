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

    public TaskController(RestTemplate restTemplate, TaskRepository taskRepository) {
        this.restTemplate = restTemplate;
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public String createTask(@RequestBody Task task) {

        taskRepository.save(task);
        restTemplate.postForObject(app2Url + "/receiveTask", task, String.class);
        return "Task sent successfully";


    }

}

