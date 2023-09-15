package com.example.rinha_backend.domain.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppErrorException extends Exception {
    String message;
    HttpStatus status;
    public AppErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
