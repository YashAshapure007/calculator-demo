package org.example.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

public class CalculatorRequest {
    
    @NotNull(message = "First number is required")
    @DecimalMin(value = "-999999999.99", message = "First number must be greater than or equal to -999999999.99")
    @DecimalMax(value = "999999999.99", message = "First number must be less than or equal to 999999999.99")
    private Double firstNumber;
    
    @NotNull(message = "Second number is required")
    @DecimalMin(value = "-999999999.99", message = "Second number must be greater than or equal to -999999999.99")
    @DecimalMax(value = "999999999.99", message = "Second number must be less than or equal to 999999999.99")
    private Double secondNumber;
    
    @NotNull(message = "Operation is required")
    private String operation;
    
    // Default constructor
    public CalculatorRequest() {}
    
    // Constructor with parameters
    public CalculatorRequest(Double firstNumber, Double secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }
    
    // Getters and Setters
    public Double getFirstNumber() {
        return firstNumber;
    }
    
    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }
    
    public Double getSecondNumber() {
        return secondNumber;
    }
    
    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
}

