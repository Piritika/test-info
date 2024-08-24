package ru.tearose.test_info.integration.http.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tearose.test_info.exception.IncorrectUserDataException;

@Slf4j
@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(IncorrectUserDataException.class)
    public ResponseEntity<String> handleIncorrectUserDataException(IncorrectUserDataException e) {
        log.info("start handleIncorrectUserDataException");

        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.info("start handleException");

        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
