package edu.com.hotelapi.Exception;


import edu.com.hotelapi.Exception.Errors.ExDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Constantes para keys de respuesta
    private static final String MESSAGE = "message";
    private static final String CODE = "code";
    private static final String ERRORS = "errors";

    //
    @ExceptionHandler(ExDataNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDataNotFound(ExDataNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Metodo helper para respuestas consistentes
    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put(MESSAGE, message);
        response.put(CODE, status.value());
        return ResponseEntity.status(status).body(response);
    }
}

