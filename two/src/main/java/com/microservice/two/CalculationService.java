package com.microservice.two;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    // Implement your fake calculation logic here
    public String performFakeCalculation() {
        return "Fake Calculation Result";
    }
}