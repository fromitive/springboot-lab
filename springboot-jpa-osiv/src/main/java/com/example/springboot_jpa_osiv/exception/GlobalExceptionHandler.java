package com.example.springboot_jpa_osiv.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity
                .badRequest()
                .body("요청값이 유효하지 않습니다: [%s]".formatted(e.getAllErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<Void> handle(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
