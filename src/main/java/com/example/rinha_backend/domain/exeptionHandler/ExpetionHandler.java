package com.example.rinha_backend.domain.exeptionHandler;

import com.example.rinha_backend.domain.errors.AppErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExpetionHandler {
        @ExceptionHandler(AppErrorException.class)
        public ResponseEntity<Map<String, String>> handleConstraintViolationException(AppErrorException appErrorExeption) {
            Map<String, String> errors = new HashMap<>();
            errors.put("error", appErrorExeption.getMessage());
            return new ResponseEntity<>(errors, appErrorExeption.getStatus());
        }
}
