package com.microservice.one.controller;
import com.microservice.one.domain.Task;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/tasks")
public class TaskController {



    private final RestTemplate restTemplate;

    public TaskController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public String createTask(@RequestBody Task task) {

        String app2Url = "http://localhost:8082";
        restTemplate.postForObject(app2Url + "/receiveTask", task, String.class);
        return "Task sent successfully";


    }

}

