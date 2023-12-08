package com.microservice.two;

import com.microservice.two.domain.TaskDto;
import com.microservice.two.service.CalculationService;
import com.microservice.two.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CalculationServiceTest {

    @InjectMocks
    private CalculationService calculationService;

    @Mock
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void performFakeCalculation_shouldSendTaskToRabbitMQ() {
        // Arrange
        TaskDto task = new TaskDto();
        task.setId(1L);
        task.setDescription("Sample Task Description");

        // Act
        calculationService.performFakeCalculation(task);

        // Assert
        // Verify that taskService.sendTaskToRabbitMQ was called with the correct task
        verify(taskService).sendTaskToRabbitMQ(any(TaskDto.class));
    }
}
