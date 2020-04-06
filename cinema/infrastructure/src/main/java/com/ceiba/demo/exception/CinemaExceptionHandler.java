package com.ceiba.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CinemaExceptionHandler {

    private static final String MENSAJE_ERROR_INESPERADO = "Ocurrio un problema inesperado en el sistema";

    @ExceptionHandler(value = CinemaException.class)
    public ResponseEntity<Object> handleException(CinemaException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> handleException(MovieNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return new ResponseEntity<>(MENSAJE_ERROR_INESPERADO, HttpStatus.NOT_FOUND);
    }
}
