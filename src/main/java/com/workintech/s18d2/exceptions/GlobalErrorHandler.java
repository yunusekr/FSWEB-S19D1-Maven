package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(PlantException plantException){
        log.error(plantException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(plantException.getMessage());
        return new ResponseEntity<>(errorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception){
        log.error(exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}