package br.com.eventox.application.controllers;

import br.com.eventox.application.exceptions.DomainException;
import br.com.eventox.application.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Response> handleDomainException(DomainException exception) {
        return new ResponseEntity<>(new Response(
                exception.getCode(), exception.getMessage()
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(new Response(
                "NOT_FOUND", exception.getMessage()
        ), HttpStatus.NOT_FOUND);
    }
}
