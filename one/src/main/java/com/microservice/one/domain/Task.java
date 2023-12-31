package com.microservice.one.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

