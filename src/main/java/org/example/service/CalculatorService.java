package org.example.service;

import org.example.dto.CalculatorResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public CalculatorResponse calculate(Double firstNumber, Double secondNumber, String operation) {
        try {
            Double result = null;
            String operationSymbol = "";
            
            switch (operation.toLowerCase()) {
                case "add":
                case "addition":
                case "+":
                    result = firstNumber + secondNumber;
                    operationSymbol = "+";
                    break;
                    
                case "subtract":
                case "subtraction":
                case "-":
                    result = firstNumber - secondNumber;
                    operationSymbol = "-";
                    break;
                    
                case "multiply":
                case "multiplication":
                case "*":
                    result = firstNumber * secondNumber;
                    operationSymbol = "*";
                    break;
                    
                case "divide":
                case "division":
                case "/":
                    if (secondNumber == 0) {
                        return CalculatorResponse.error("Division by zero is not allowed", "/", firstNumber, secondNumber);
                    }
                    result = firstNumber / secondNumber;
                    operationSymbol = "/";
                    break;
                    
                case "power":
                case "exponent":
                case "^":
                    result = Math.pow(firstNumber, secondNumber);
                    operationSymbol = "^";
                    break;
                    
                case "modulo":
                case "mod":
                case "%":
                    if (secondNumber == 0) {
                        return CalculatorResponse.error("Modulo by zero is not allowed", "%", firstNumber, secondNumber);
                    }
                    result = firstNumber % secondNumber;
                    operationSymbol = "%";
                    break;
                    
                default:
                    return CalculatorResponse.error("Unsupported operation: " + operation, operation, firstNumber, secondNumber);
            }
            
            // Round to 4 decimal places for better precision
            result = Math.round(result * 10000.0) / 10000.0;
            
            return CalculatorResponse.success(result, operationSymbol, firstNumber, secondNumber);
            
        } catch (Exception e) {
            return CalculatorResponse.error("Calculation error: " + e.getMessage(), operation, firstNumber, secondNumber);
        }
    }
}

