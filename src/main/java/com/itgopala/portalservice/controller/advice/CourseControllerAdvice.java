package com.itgopala.portalservice.controller.advice;

import com.itgopala.portalservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class CourseControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> resourceNotFoundHandler(ResourceNotFoundException e) {
        return new ResponseEntity<>(Collections.singletonMap("message", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
