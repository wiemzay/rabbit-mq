package com.microservice.two.domain;



import lombok.Getter;
import lombok.Setter;

/**
 * The TaskDto class represents a data transfer object (DTO) for tasks.
 */
@Setter
@Getter
public class TaskDto {

    private Long id;
    private String description;
    private long result;

    /**
     * Constructs an empty TaskDto.
     */
    public TaskDto() {

    }

    /**
     * Constructs a TaskDto with the specified ID and description.
     *
     * @param id          The unique identifier of the task.
     * @param description The description of the task.
     */
    public TaskDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}

