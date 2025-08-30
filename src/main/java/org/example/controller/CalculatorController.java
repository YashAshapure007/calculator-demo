package org.example.controller;

import org.example.dto.CalculatorRequest;
import org.example.dto.CalculatorResponse;
import org.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class
CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;
    
    @PostMapping("/calculate")
    public ResponseEntity<CalculatorResponse> calculate(@Valid @RequestBody CalculatorRequest request, 
                                                      BindingResult bindingResult) {
        
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            
            String errorMessage = String.join("; ", errors);
            CalculatorResponse errorResponse = CalculatorResponse.error(
                "Validation failed: " + errorMessage, 
                request.getOperation(), 
                request.getFirstNumber(), 
                request.getSecondNumber()
            );
            
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        // Perform calculation
        CalculatorResponse response = calculatorService.calculate(
            request.getFirstNumber(), 
            request.getSecondNumber(), 
            request.getOperation()
        );
        
        // Return appropriate HTTP status based on success/error
        if (response.getResult() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    
    @GetMapping("/operations")
    public ResponseEntity<String[]> getSupportedOperations() {
        String[] operations = {
            "add, addition, +",
            "subtract, subtraction, -", 
            "multiply, multiplication, *",
            "divide, division, /",
            "power, exponent, ^",
            "modulo, mod, %"
        };
        return ResponseEntity.ok(operations);
    }
    
    // Exception handler for general errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CalculatorResponse> handleException(Exception e) {
        CalculatorResponse errorResponse = CalculatorResponse.error(
            "Internal server error: " + e.getMessage(), 
            "unknown", 
            null, 
            null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

