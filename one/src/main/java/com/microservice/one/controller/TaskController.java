package com.microservice.one.controller;
import com.microservice.one.TaskRepository;
import com.microservice.one.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;


    private final RestTemplate restTemplate;

    public TaskController(TaskRepository taskRepository, RestTemplate restTemplate) {
        this.taskRepository = taskRepository;
        this.restTemplate = restTemplate;
    }
    private final String app2Url = "http://localhost:8082"; // Change this to the actual URL of App2

    @PostMapping
    public String createTask(@RequestBody Task task) {

        restTemplate.postForObject(app2Url + "/receiveTask", task, String.class);
        return "Task sent successfully";


    }

}

