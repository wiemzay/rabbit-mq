package com.microservice.two.domain;



import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class Task {

    private Long id;
    private String description;
    private long result;
    public Task() {

    }

    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}

