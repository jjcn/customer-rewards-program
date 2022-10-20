package com.joeyjin.rewards_program.controller;

import com.joeyjin.rewards_program.exception.NoPurchaseRecordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoPurchaseRecordException.class)
    public ResponseEntity<String> noPurchaseRecordHandler(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentHandler(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
