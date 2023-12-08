package com.microservice.two.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The TaskDto class represents a data transfer object (DTO) for tasks.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String description;
    private long result;

}

