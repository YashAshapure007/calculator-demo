package org.example.dto;

public class CalculatorResponse {
    
    private Double result;
    private String message;
    private String operation;
    private Double firstNumber;
    private Double secondNumber;
    
    // Default constructor
    public CalculatorResponse() {}
    
    // Constructor with parameters
    public CalculatorResponse(Double result, String message, String operation, Double firstNumber, Double secondNumber) {
        this.result = result;
        this.message = message;
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    
    // Constructor for success response
    public static CalculatorResponse success(Double result, String operation, Double firstNumber, Double secondNumber) {
        return new CalculatorResponse(result, "Calculation successful", operation, firstNumber, secondNumber);
    }
    
    // Constructor for error response
    public static CalculatorResponse error(String message, String operation, Double firstNumber, Double secondNumber) {
        return new CalculatorResponse(null, message, operation, firstNumber, secondNumber);
    }
    
    // Getters and Setters
    public Double getResult() {
        return result;
    }
    
    public void setResult(Double result) {
        this.result = result;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
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
}

