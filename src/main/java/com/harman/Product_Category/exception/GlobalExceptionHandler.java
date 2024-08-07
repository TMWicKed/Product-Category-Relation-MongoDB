package com.harman.Product_Category.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                               WebRequest request) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Resource not found");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Invalid input");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, String> errorDetails = new HashMap<>();errorDetails.put("error", "Internal server error");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
